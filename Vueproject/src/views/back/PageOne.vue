<template>
    <div style="overflow:hidden;">
        <div class="demo-input-suffix">
            <el-input
                    placeholder="请选择日期"
                    suffix-icon="el-icon-date"
                    v-model="input1"
                    style="width: 150px;float: left;margin:5px" >
            </el-input>
            <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    v-model="input2"
                    style="width: 150px;float: left;margin:5px">
            </el-input>
            <el-button style="width: 70px;float: left;margin:5px">查询</el-button>
            <el-button style="width: 70px;float: left;margin:5px" @click="resetForm">重置</el-button>
        </div>
        <div>
            <el-container style="height: 500px; border: 1px solid #eee;clear: both">
                <el-main>
                    <el-table :data="tableData">
                        <el-table-column type="selection" width="55"></el-table-column>
                        <el-table-column prop="id" label="id" width="50">
                        </el-table-column>
                        <el-table-column prop="username" label="用户名" width="100">
                        </el-table-column>
                        <el-table-column prop="nickname" label="昵称" width="100">
                        </el-table-column>
                        <el-table-column prop="avatar" label="头像" width="150">
                        </el-table-column>
                        <el-table-column prop="sex" label="性别" width="80">
                        </el-table-column>
                        <el-table-column prop="birthday" label="生日" width="100">
                        </el-table-column>
                        <el-table-column prop="email" label="邮箱" width="150">
                        </el-table-column>
                        <el-table-column
                                fixed="right"
                                label="操作"
                                width="100">
                            <template slot-scope="scope">
                                <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                                <el-button type="text" size="small">编辑</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-main>
            </el-container>
        </div>
    </div>

</template>

<script>
export default {
    name: "PageOne",
    data() {
        return {
            input1: '',
            input2: '',
            tableData: [{
                id: 1,
                username: 'daetz',
                nickname: 'daetz',
                avatar:'localhost：8080',
                sex:'男',
                birthday:'2020.3.4',
                email:'123@qq.com',
            },{
                id: 2,
                username: 'daetz2',
                nickname: 'daetz2',
                avatar:'localhost：8080',
                sex:'男',
                birthday:'2020.3.4',
                email:'123@qq.com',
            }
            ]
        }
    },
    methods:{
      resetForm(){
          this.input1='';
          this.input2='';
      },
      search(){
        const _this = this;
        request.get('/admin/findByName/'+_this.input2).then(function(resp) {
          console.log(resp)
          _this.tableData=resp.data
          _this.total=resp.data.length
        });
      },
      addUser(){
        this.$router.push('/addUser')
      },
      deleteUser(row){
        const _this=this
        request.delete('/admin/delete/'+row.id).then(function (resp){
          //console.log(resp)
          alert("删除成功")
          window.location.reload();
        })
      },
      edit(row) {
        this.$router.push({
          path:'/update',
          query:{
            id:row.id
          }
        })
        //row.id<点击的id>
      },
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