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
            <el-button style="width: 70px;float: left;margin:5px"  @click="addUser" type="primary" plain>新增</el-button>
            <el-button style="width: 140px;float: left;margin:5px" type="danger" plain>批量删除</el-button>
        </div>
        <div>
            <el-container style="height: 500px; border: 1px solid #eee;clear: both;">
                <el-main style="padding: 0px">
                    <el-table :data="tableData">
                        <el-table-column type="selection" width="55"></el-table-column>
                        <el-table-column prop="id" label="id" width="50">
                        </el-table-column>
                        <el-table-column prop="goods_no" label="编号" width="100">
                        </el-table-column>
                        <el-table-column prop="name" label="名称" width="100">
                        </el-table-column>
                        <el-table-column prop="price" label="单价" width="100">
                        </el-table-column>
                        <el-table-column prop="image" label="图片" width="150">
                        </el-table-column>
                        <el-table-column prop="introduction" label="介绍" width="150">
                        </el-table-column>
                        <el-table-column prop="category_id" label="类别ID" width="100">
                        </el-table-column>
                        <el-table-column prop="sale" label="销量">
                        </el-table-column>
                        <el-table-column prop="store" label="库存">
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
    name: "PageFour",
    data() {
        return {
            input1: '',
            input2: '',
            tableData: [{
                id: 1,
                goods_no: '001',
                name: '电脑',
                price:6999.9,
                image:'loaclhost:8080',
                introduction:'这是一个好用的电脑',
                category_id:'1',
                sale:3333,
                store:222
            },{
                id: 2,
                goods_no: '002',
                name: '手机',
                price:1999.9,
                image:'loaclhost:8080',
                introduction:'这是一个好用的手机',
                category_id:2,
                sale:3333,
                store:222
            },{
                id: 3,
                goods_no: '003',
                name: '平板',
                price:2999.9,
                image:'loaclhost:8080',
                introduction:'这是一个好用的平板',
                category_id:3,
                sale:3333,
                store:222
            }
            ]
        }
    },
    methods:{
        resetForm(){
            this.input1='';
            this.input2='';
        }
    },
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