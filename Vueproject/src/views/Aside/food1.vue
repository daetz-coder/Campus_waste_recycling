<template>
    <div>
        <el-row>
            <el-col :span="8" v-for="item in goods" :key="item.id">
                <el-card shadow="hover" style="margin:20px 0;">
                    <div style="text-align: center;">
                        <img :src="item.imageUrl" style="height: 150px; width: 150px;">
                    </div>
                    <div style="padding: 14px;">
                        <span style="font-size: 14px;font-weight: bold">{{item.name}}</span>
                        <div style="margin-top:12px;">
                            <span style="font-size: 18px;color: #f60;">¥{{item.price}}</span>
                        </div>
                        <div style="text-align:right;margin-top:12px;">
                            <router-link :to="'/index/detail?id='+item.id">
                                <el-button type="primary" size="small">查看详情</el-button>
                            </router-link>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size=3
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: 'food1',
  data () {
    return {
      total:null,
      goods:null,
    }
  },
  methods: {
    page(currentPage){ //alert("wait...") 动态分页
      const _this=this
      request.get('/goods/findByCategory/'+currentPage+'/3/4').then(function (resp){
        _this.goods=resp.data.data.records
        _this.total=resp.data.data.total
      })
    },
  },
  created() { //alert 初始化操作
    const _this=this
    request.get('/goods/findByCategory/1/3/4').then(function (resp){
      console.log(resp.data)
      _this.goods=resp.data.data.records
      _this.total=resp.data.data.total
      _this.size=resp.data.data.size
    })
  },
}
</script>

<style scoped>
</style>