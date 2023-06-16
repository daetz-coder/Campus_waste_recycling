<template>
    <div>
        <el-card>
            <div slot="header" class="card-header">
                <h4>个人信息</h4>
            </div>
            <div class="card-body">
                <el-row>
                    <el-col :span="12">
                        <el-form label-width="80px" :model="user" ref="userForm">
                            <el-form-item label="用户名">
                                <span>{{ user.username }}</span>
                            </el-form-item>
                            <el-form-item label="昵称">
                                <el-input v-model="user.nickname"></el-input>
                            </el-form-item>
                            <el-form-item label="性别">
                                <el-input v-model="user.sex"></el-input>
                            </el-form-item>
                            <el-form-item label="生日">
                                <el-date-picker v-model="user.birthday" type="date"></el-date-picker>
                            </el-form-item>
                            <el-form-item label="邮箱">
                                <el-input v-model="user.email"></el-input>
                            </el-form-item>
                            <el-form-item label="位置">
                                <el-input v-model="user.position"></el-input>
                            </el-form-item>
                            <el-form-item label="权限">
                                <el-radio-group v-model="user.role" >
                                    <el-radio :label="1">管理员</el-radio>
                                    <el-radio :label="0">普通用户</el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('user')">修改</el-button>
                                <el-button @click="resetForm('user')">重置</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="12">
                        <el-avatar :src="user.avatar" shape="circle" size="large" style="position: relative;right: 75%"></el-avatar>
                    </el-col>
                </el-row>
            </div>
        </el-card>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "AdminChangeInformation",
  data() {
    return {
      user: null,
    };
  },
  methods: {
    submitForm(formName) {
      // 发送修改用户请求
      request
          .post(`/user/update`, this.user)
          .then(resp => {
            if (resp.data.code === "200") {
              this.$message.success("用户信息修改成功！");
              this.$router.push("/index/home");
            } else {
              this.$message.error("用户信息修改失败");
            }
          })
          .catch(error => {
            console.log(error);
          });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
  created() {
    const storedUser = localStorage.getItem('user');
    const user = JSON.parse(storedUser);
    const _this = this;
    request
        .get(`/user/findByName/${user.username}`)
        .then(resp => {
          _this.user = resp.data.data;
          console.log(user.role)
        })
        .catch(error => {
          console.log(error);
        });
  },
};
</script>

<style scoped>
.el-form {
    text-align: left;
}
</style>
