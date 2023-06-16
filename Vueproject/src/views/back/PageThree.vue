<template>
    <div style="overflow:hidden;">
        <div>
            <el-container style="height: 500px; border: 1px solid #eee;clear: both" >
                <el-main>
                    <el-table :data="tableData">
                        <el-table-column type="selection" width="55"></el-table-column>
                        <el-table-column prop="id" label="id" width="250">
                        </el-table-column>
                        <el-table-column prop="name" label="类名" width="250">
                        </el-table-column>
                        <el-table-column prop="parentName" label="父级类名">
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
                </el-main>
            </el-container>
        </div>
    </div>

</template>

<script>
import request from "@/utils/request";

export default {
    name: "PageThree",
    data() {
        return {
            input:null,
            tableData:null,
        }
    },
    methods:{
      deleteUser(row){
        request.delete('/admin/deleteByCategory/'+row.id).then((resp)=>{
          //console.log(resp)
          this.$message.success("删除成功")
          window.location.reload();
        })
      },
    },
    created() {
      const _this = this;
      request
        .get("/admin/findCategory/")
        .then(resp => {
          console.log(resp)
          _this.tableData = resp.data.data;
        })
        .catch(error => {
          console.log(error);
        });
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