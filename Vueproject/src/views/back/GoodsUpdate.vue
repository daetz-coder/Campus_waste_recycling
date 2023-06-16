<template>
    <div>
        <el-table :data="products" style="width: 100%">
            <el-table-column label="商品名称" prop="name"></el-table-column>
            <el-table-column label="价格" prop="price"></el-table-column>
            <el-table-column label="图片链接" prop="imageUrl">
                <template slot-scope="scope">
                    <img :src="scope.row.imageUrl" alt="Product Image" style="width: 100px; height: 100px;">
                </template>
            </el-table-column>
            <el-table-column label="描述" prop="description"></el-table-column>
            <el-table-column label="数量" prop="store"></el-table-column>
            <el-table-column label="分类" prop="categoryId"></el-table-column>
            <el-table-column label="使用年限" prop="usedYear"></el-table-column>
            <el-table-column label="状态">
                <template slot-scope="scope">
                    <el-switch
                            v-model="scope.row.state"
                            :active-value="1"
                            :inactive-value="0"
                            active-color="#13ce66"
                            inactive-color="#ff4949"
                            @change="updateProduct(scope.row)"
                    ></el-switch>
                </template>
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button type="text" size="small" @click="deleteUser(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="3"
                :total="total"
                @current-change="page"
        ></el-pagination>

    </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "ProductManagement",
  data() {
    return {
      products: null,
      total: null,
    };
  },
  methods: {
    deleteUser(row){
      request.delete('/goods/deleteByGoodsId/'+row.id).then((resp)=>{
        //console.log(resp)
        this.$message.success("删除成功")
        window.location.reload();
      });
    },
    updateProduct(product) {
      const newState = product.state === 0 ? 1 : 0; // 根据 state 的值切换状态
      request
          .put(`/goods/${product.id}`)
          .then((resp) => {
            if (resp.data.code === "200") {
              this.$message.success("修改商品状态成功");
            } else {
              this.$message.error("修改商品状态失败");
            }
          })
          .catch((error) => {
            console.error("Failed to update product:", error);
          });
    },
    page(currentPage) {
      const _this = this;
      request
          .get(`/goods/findAll/${currentPage}/3`)
          .then(function (resp) {
            _this.products = resp.data.data.records;
            _this.total = resp.data.data.total;
          })
          .catch((error) => {
            console.error("Failed to fetch products:", error);
          });
    },
  },
  created() {
    this.page(1);
  },
};
</script>

<style scoped>
h1 {
    text-align: center;
    margin-bottom: 20px;
}
</style>
