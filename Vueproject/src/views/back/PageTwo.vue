<template>
    <div style="overflow:hidden;">
        <div class="demo-input-suffix">
            <el-input
                    placeholder="按照姓名查找"
                    prefix-icon="el-icon-search"
                    v-model="input"
                    style="width: 150px;float: left;margin:5px">
            </el-input>
            <el-button style="width: 70px;float: left;margin:5px" @click="search">查询</el-button>
            <el-button style="width: 70px;float: left;margin:5px" @click="resetForm">重置</el-button>
            <el-button style="width: 70px;float: left;margin:5px"  @click="addUser" type="primary" plain>新增</el-button>
            <el-button style="width: 140px;float: left;margin:5px" type="danger" plain>批量删除</el-button>
        </div>
        <div>
            <el-container style="height: 500px; border: 1px solid #eee;clear: both">
                <el-main>
                    <el-table :data="tableData">
                        <el-table-column type="selection" width="55"></el-table-column>
                        <el-table-column prop="id" label="id" width="60">
                        </el-table-column>
                        <el-table-column prop="username" label="用户名" width="120">
                        </el-table-column>
                        <el-table-column prop="nickname" label="昵称">
                        </el-table-column>
                        <el-table-column prop="avatar" label="头像">
                            <template slot-scope="scope">
                                <img :src="scope.row.avatar" style="width: 50px; height: 50px">
                            </template>
                        </el-table-column>
                        <el-table-column prop="sex" label="性别" width="120">
                        </el-table-column>
                        <el-table-column prop="birthday" label="生日">
                        </el-table-column>
                        <el-table-column prop="email" label="邮箱">
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
                            :page-size=3
                            :total="total"
                            @current-change="page">
                    </el-pagination>
                </el-main>
            </el-container>
        </div>
    </div>
</template>

<script>

import request from "@/utils/request";

export default {
    name: "PageTwo",
    methods:{
        search(){
          const _this = this;
          request.get('/admin/findByName/'+_this.input).then(function(resp) {
            console.log(resp)
            _this.tableData=resp.data
            _this.total=resp.data.length
          });
        },
        addUser(){
          this.$router.push('/admin/addUser')
        },
        resetForm(){
            this.input='';
        },
        deleteUser(row){
          request.delete('/admin/delete/'+row.id).then((resp)=>{
            //console.log(resp)
            this.$message.success("删除成功")
            window.location.reload();
          })
        },
        page(currentPage){ //alert("wait...") 动态分页
            const _this=this
            request.get('/findUser/'+currentPage+'/3').then(function (resp){
                _this.tableData=resp.data.records
                _this.total=resp.data.total
            })
        }
    },
    created() { //alert 初始化操作
        const _this=this
        request.get('/findUser/1/3').then(function (resp){
            _this.tableData=resp.data.records
            _this.total=resp.data.total
            _this.size=resp.data.size
            console.log(resp.data)
        })
    },
    data() {
        return {
          input:null,
          total:null,
          tableData:null,
          avatar:''
        }
    }
}
</script>

<style scoped>
.el-container::-webkit-scrollbar {
    width: 0 !important;
    height: 0 !important;
}
.el-main::-webkit-scrollbar {
    width: 0 !important;
    height: 0 !important;
}
</style>