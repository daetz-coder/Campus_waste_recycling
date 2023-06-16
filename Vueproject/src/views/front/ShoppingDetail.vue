<template>
    <div>
        <div style="margin-top: 20px; margin-left: 20px; font-size: 24px;">
            商品详情
        </div>
        <el-row style="margin-top: 20px;">
            <el-col :span="8">
                <img :src="goods.imageUrl" style="height: 350px; width: 350px; margin: 20px;">
            </el-col>
            <el-col :span="12" style="padding: 20px 20px 20px 40px;">
                <div style="margin-bottom: 20px; font-size: 28px; font-weight: bold;">{{ goods.name }}</div>
                <div style="font-size: 20px; color: #f60;">¥{{ goods.price }}</div>
                <div style="margin-top: 24px;">商品详情：{{ goods.description }}</div>
                <div style="margin-top: 24px;">库存：{{ goods.usedYear }}</div>
                <div style="margin-top: 24px;">销量：{{ goods.sale }}</div>
                <div style="margin-top: 24px;">库存：{{ goods.store }}</div>
                <div style="position: absolute; bottom: 20px; right: 40px;">
                    <el-button type="success" @click="buy">加入购物车</el-button>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: 'ShoppingDetail',
  data() {
    return {
      goods: null,
    }
  },
  methods: {
    buy() {
      const cart={
        goodsId:this.goods.id,
        goodsName:this.goods.name,
        imageUrl:this.goods.imageUrl,
        count:1,
        price:this.goods.price,
        usedYear:this.goods.usedYear,
      };
      request.post("/cart/saveOrUpdate", cart)
          .then(resp => {
            if (resp.data.code === "200") {
              this.$message.success("加入购物车成功");
            } else {
              this.$message.error("加入购物车失败");
            }
          });
      },
  },
  created() {
    const _this = this;
    request.get(`/goods/findById/${this.$route.query.id}`).then(function(resp) {
      console.log(resp.data);
      _this.goods = resp.data.data;
      console.log(_this.goods);
    });
    const storedUser = localStorage.getItem('user');
    const user = JSON.parse(storedUser);
    this.username=user.username
  },
}
</script>

<style scoped>
</style>
