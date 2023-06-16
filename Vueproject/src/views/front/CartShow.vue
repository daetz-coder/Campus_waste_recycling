<template>
    <div>
        <div style="margin-top: 20px; margin-left: 20px; font-size: 24px;">
            购物车
        </div>
        <el-row style="margin-top: 20px;">
            <el-col :span="24">
                <el-table :data="cartItems" style="width: 100%">
                    <el-table-column prop="goodsName" label="商品名称"></el-table-column>
                    <el-table-column prop="count" label="数量">
                        <template slot-scope="scope">
                            <el-input-number v-model="scope.row.count" @change="updateItem(scope.row)"></el-input-number>
                        </template>
                    </el-table-column>
                    <el-table-column prop="price" label="单价"></el-table-column>
                    <el-table-column label="小计">
                        <template slot-scope="scope">
                            {{ scope.row.count * scope.row.price }}
                        </template>
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button type="danger" size="mini" @click="removeItem(scope.$index)">
                                删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
        <div style="margin-top: 20px; text-align: right;">
            <span style="font-weight: bold;">总计：</span>
            <span>{{ total }}</span>
        </div>
        <div style="margin-top: 20px; text-align: right;">
            <el-button type="primary" @click="checkout">结算</el-button>
        </div>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "CartShow",
  data() {
    return {
      cartItems: [],
      total: 0
    };
  },
  methods: {
    updateItem(item) {
      // Update the item in the server
      request.post("/cart/saveOrUpdate", item)
          .then(resp => {
            if (resp.data.code === "200") {
              this.$message.success("购物车更新成功");
            } else {
              this.$message.error("购物车更新失败");
            }
          });

      // Recalculate the total price
      this.calculateTotal();
    },
    removeItem(index) {
      const item = this.cartItems[index];
      // Remove the item from the server
      request.post("/cart/remove", item.id)
          .then(resp => {
            if (resp.data.code === "200") {
              this.$message.success("商品删除成功");
            } else {
              this.$message.error("商品删除失败");
            }
          });

      // Remove the item from the local cartItems array
      this.cartItems.splice(index, 1);

      // Recalculate the total price
      this.calculateTotal();
    },
    calculateTotal() {
      this.total = this.cartItems.reduce((sum, item) => sum + item.count * item.price, 0);
    },
    checkout() {
      // 循环处理每个产品
      for (const item of this.cartItems) {
        // 准备订单数据
        const order = {
          username: this.username,
          goodsId: item.id, // 将当前产品ID添加到订单对象中
          goodsName: item.goodsName, // 将商品名称添加到订单对象中
          count: item.count, // 将数量添加到订单对象中
          price: item.price, // 将单价添加到订单对象中
          subtotal: item.count * item.price // 将小计添加到订单对象中
        };
        // 将订单数据发送到服务器
        request.post("/order/create", order)
            .then(resp => {
              if (resp.data.code === "200") {
                this.$message.success("订单创建成功");
                request.post("/cart/deleteById/"+order.goodsId)
                    .then(resp => {
                      if (resp.data.code === "200"){
                        this.$message.info("购物车清除成功");
                      }else{
                        this.$message.error("购物车清除失败");
                      }
                    });
              } else {
                this.$message.error("订单创建失败");
              }
            });
      }

      // 重置cartItems和total
      this.cartItems = [];
      this.total = 0;

      // 显示成功消息
      this.$message.success("结算成功");
    }
  },
  created() {
    const storedUser = localStorage.getItem('user');
    const user = JSON.parse(storedUser);
    this.username=user.username
    // Fetch the cart items from the server
    request.get("/cart/findCart/")
        .then(resp => {
          console.log(resp)
          if (resp.data.code === "200") {

            this.cartItems = resp.data.data;
            // Calculate the initial total price
            this.calculateTotal();
          } else {
            this.$message.error("购物车数据加载失败");
          }
        });
  }
};
</script>

<style scoped>
</style>
