<template>
    <div>
        <el-button type="text"></el-button>
        <el-dialog title="后台管理员登录" :visible.sync="dialogFormVisible">
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
    name: "AdminLogin",
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
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            request.post('http://localhost:8081/user/login', this.ruleForm)
                .then(response => {
                  if (response.data) {
                    this.$message.success('登录成功');
                    //将token写入本地
                    localStorage.setItem('username', JSON.stringify({ token: response.data.data.token }));
                    this.dialogFormVisible = false;
                    this.$router.push('/admin')
                  } else {
                    this.$message.error('用户名或密码不正确')
                    this.$router.push('/adminLogin')
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
    },
}
</script>