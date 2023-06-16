<template>
    <div>
        <el-dialog title="用户登录" :visible.sync="dialogFormVisible">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="ruleForm.username" style="float: left"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="ruleForm.password" style="float: left"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>


import request from "@/utils/request";

export default {
    name: "UserLogin",
    data() {
        return {
            activeIndex: '',
            dialogFormVisible: false,
            ruleForm: {
                username: '',
                password:'',
            },
            input:'',
            rules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                ]
            },
        }
    },
    created() {
      this.dialogFormVisible=true
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            request.post('/user/login', this.ruleForm)
                .then(res => {
                  console.log(res.data)
                  console.log(res.data.code)
                  if (res.data.code === '200') {
                    this.$message.success("登录成功");
                    localStorage.setItem("user", JSON.stringify(res.data.data));  // 存储用户信息到浏览器
                    this.$router.push("/index/home");
                  }else {
                    this.$message.error("用户名或密码错误");
                  }
                })
                .catch(error => {
                  alert('服务器出错，请稍后再试');
                });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        showLoginDialog() {
            this.dialogFormVisible = true;
        },
    }
}
</script>