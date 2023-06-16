<template>
    <div>
        <el-row>
            <el-col :span="8" v-for="item in goods" :key="item.id">
                <el-card shadow="hover" style="margin:20px 0;">
                    <div style="text-align: center;">
                        <img :src="item.imgUrl" style="height: 150px; width: 150px;">
                    </div>
                    <div style="padding: 14px;">
                        <span style="font-size: 14px;font-weight: bold">{{item.name}}</span>
                        <div style="margin-top:12px;">
                            <span style="font-size: 18px;color: #f60;">¥{{item.price}}</span>
                        </div>
                        <div style="text-align:right;margin-top:12px;">
                            <router-link :to="'/index/detail?'+item.id">
                                <el-button type="primary" size="small">查看详情</el-button>
                            </router-link>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
  name: 'ShoppingHome',
  data () {
    return {
      goods: [
        {
          id: 1,
          name: '商品1',
          price: '79.00',
          imgUrl: 'xxx'
        },
        {
          id: 2,
          name: '商品2',
          price: '89.00',
          imgUrl: 'xxx'
        },
        {
          id: 3,
          name: '商品3',
          price: '199.00',
          imgUrl: 'xxx'
        },
        {
          id: 4,
          name: '商品4',
          price: '49.99',
          imgUrl: 'xxx'
        }
      ]
    }
  }
}
</script>

<style scoped>
</style>