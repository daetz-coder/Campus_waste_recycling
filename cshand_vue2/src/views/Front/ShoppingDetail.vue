<template>
    <div>
        <div style="margin-top:20px;margin-left:20px;font-size:24px;">
            商品详情
        </div>
        <el-row style="margin-top:20px;">
            <el-col :span="8">
                <img :src="goods.imgUrl" style="height: 350px;width: 350px;margin: 20px;">
            </el-col>
            <el-col :span="12" style="padding:20px 20px 20px 40px;">
                <div style="margin-bottom:20px;font-size: 28px;font-weight: bold;">{{ goods.name }}</div>
                <div style="font-size: 20px;color:#f60;">¥{{ goods.price }}</div>
                <div style="margin-top:24px;">商品详情：{{ goods.detail }}</div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
  name: "ShoppingDetail",
  data () {
    return {
      goods: {
        id: 1,
        name: '商品1',
        price: '79.00',
        detail: '这是商品1的详情。',
        imgUrl: 'xxx'
      }
    }
  },
}
</script>

<style scoped>

</style>