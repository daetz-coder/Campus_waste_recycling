<template>
    <div>
        <el-card>
            <div slot="header" class="card-header">
                <h4>个人信息</h4>
            </div>
            <div class="card-body">
                <el-row>
                    <el-col :span="12">
                        <el-form label-width="80px">
                            <el-form-item label="用户名">
                                <span>{{ user.username }}</span>
                            </el-form-item>
                            <el-form-item label="昵称">
                                <span>{{ user.nickname }}</span>
                            </el-form-item>
                            <el-form-item label="性别">
                                <span>{{ user.sex }}</span>
                            </el-form-item>
                            <el-form-item label="生日">
                                <span>{{ user.birthday }}</span>
                            </el-form-item>
                            <el-form-item label="邮箱">
                                <span>{{ user.email }}</span>
                            </el-form-item>
                            <el-form-item label="位置">
                                <span>{{ user.position }}</span>
                            </el-form-item>
                            <el-form-item label="权限">
                                <span>{{ user.role === 1 ? '管理员' : '普通用户' }}</span>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="$router.push({path:'/index/change'})" style="position: absolute;left: 50%">修改</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="12">
                        <el-avatar :src="user.avatar" shape="circle" size="200px" style="position: relative;right: 75%"></el-avatar>
                    </el-col>
                </el-row>
            </div>
        </el-card>
    </div>
</template>

<script>

import request from "@/utils/request";


export default {
  name: "UserInformation",
  data() {
    return {
      user:null,
    };
  },
  methods: {
    // submitForm(formName) {
    //   request.post(`/used/SaveById/${this.$route.query.award_id}/${this.$route.query.instance_id}`).then(resp => {
    //     // 处理响应
    //     if (resp.data.code === "200") {
    //       this.$message.success("使用记录生成成功！")
    //     } else {
    //       this.$message.error("奖券使用失败");
    //     }
    //   }).catch(error=>{
    //     console.log(error);
    //   })
    // },
    // resetForm(formName) {
    //   this.ruleForm.instanceDurationTime = null;
    // },
  },
  created() {
    const storedUser = localStorage.getItem('user');
    const user = JSON.parse(storedUser);
    //console.log(user);
    //console.log(user.username)
    this.username=user.username
    this.password=user.password
    const _this = this;
    request
        .get("/user/findByName/" + user.username)
        .then(resp => {
          console.log(resp)
          _this.user = resp.data.data;
        })
        .catch(error => {
          console.log(error);
        });
  }
};
</script>

<style scoped>
.el-form {
    text-align: left;
}
</style>
