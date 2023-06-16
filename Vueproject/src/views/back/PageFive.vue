<template>
    <div>
        <el-table :data="orders" style="width: 100%">
            <el-table-column prop="id" label="订单ID"></el-table-column>
            <el-table-column prop="username" label="用户姓名"></el-table-column>
            <el-table-column prop="goodsName" label="商品名称"></el-table-column>
            <el-table-column prop="count" label="数量"></el-table-column>
            <el-table-column prop="price" label="单价"></el-table-column>
            <el-table-column prop="subtotal" label="小计"></el-table-column>
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
                :page-size="10"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name:'PageFive',
  data() {
    return {
      total:null,
      goods:null,
      orders: [] // 存储订单数据
    };
  },
  methods: {
    page(currentPage){ //alert("wait...") 动态分页
      const _this=this
      request.get('/order/findAll/'+currentPage+'/10').then(function (resp){
        _this.orders=resp.data.data.records
        _this.total=resp.data.data.total
      })
    },
    deleteUser(row){
      request.delete('/order/deleteById/'+row.id).then((resp)=>{
        //console.log(resp)
        this.$message.success("删除成功")
        window.location.reload();
      })
    },

  },
  created() { //alert 初始化操作
    const _this=this
    request.get('/order/findAll/1/10').then(function (resp){
      console.log(resp.data)
      _this.orders=resp.data.data.records
      _this.total=resp.data.data.total
      _this.size=resp.data.data.size
    })
  },
}
</script>
