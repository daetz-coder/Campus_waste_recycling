<template>
    <div>
        <el-button type="text">用户注册页面</el-button>
        <el-dialog title="用户注册" :visible.sync="dialogFormVisible">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" :label-width="formLabelWidth" class="demo-ruleForm">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="ruleForm.username" style="float: left"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="ruleForm.password" style="float: left"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="confirmPassword">
                    <el-input v-model="ruleForm.confirmPassword" style="float: left"></el-input>
                </el-form-item>
                <el-form-item label="昵称" prop="nickname">
                    <el-input v-model="ruleForm.nickname" style="float: left"></el-input>
                </el-form-item>
                <el-form-item label="头像" prop="avatar">
                    <el-input v-model="ruleForm.avatar" style="float: left"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                    <el-radio-group v-model="ruleForm.sex" style="float: left; position: relative; top: 10px">
                        <el-radio label="男"></el-radio>
                        <el-radio label="女"></el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="生日" prop="birthday">
                    <el-date-picker v-model="ruleForm.birthday" type="date" placeholder="选择日期" style="float: left"></el-date-picker>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="ruleForm.email"></el-input>
                </el-form-item>
                <el-form-item label="地址" prop="position">
                    <el-input v-model="ruleForm.position"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
    name: "Register",
    data() {
        return {
            imageUrl: '',
            dialogFormVisible: false,
            formLabelWidth: '80px',
          ruleForm: {
            username: "",
            password: "",
            confirmPassword: "",
            nickname: "",
            avatar: "",
            sex: "",
            birthday: "",
            email: "",
            position: "",
          },
          rules: {
            username: [
              { required: true, message: "请输入用户名", trigger: "blur" },
              { min: 3, max: 20, message: "用户名长度在 3 到 20 个字符", trigger: "blur" }
            ],
            password: [
              { required: true, message: "请输入密码", trigger: "blur" },
              { min: 6, message: "密码长度至少为 6 个字符", trigger: "blur" }
            ],
            confirmPassword: [
              { required: true, message: "请再次输入密码", trigger: "blur" },
              { validator: this.validateConfirmPassword, trigger: "blur" }
            ],
            avatar: [
              { required: true, message: "请输入头像链接", trigger: "blur" },
            ],
            nickname: [
              { required: true, message: "请输入昵称", trigger: "blur" },
              { min: 3, max: 20, message: "昵称长度在 3 到 20 个字符", trigger: "blur" }
            ],
            sex: [
              { required: true, message: "请选择性别", trigger: "change" }
            ],
            birthday: [
              { type: "date", required: true, message: "请选择生日", trigger: "change" }
            ],
            email: [
              { required: true, message: "请输入邮箱", trigger: "blur" },
              { type: "email", message: "请输入有效的邮箱地址", trigger: ["blur", "change"] }
            ],
            position: [
              { required: true, message: "请输入地址", trigger: "blur" },
            ],
          },
            pickerOptions: {
                disabledDate(time) {
                    return time.getTime() > Date.now();
                },
                shortcuts: [{
                    text: '今天',
                    onClick(picker) {
                        picker.$emit('pick', new Date());
                    }
                }, {
                    text: '昨天',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24);
                        picker.$emit('pick', date);
                    }
                }, {
                    text: '一周前',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                        picker.$emit('pick', date);
                    }
                }]
            },
            value1: '',
            value2: '',
            fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]
        }
    },
    created() {
        this.dialogFormVisible=true
    },
    methods: {
      validateConfirmPassword(rule, value, callback) {
        if (value !== this.ruleForm.password) {
          callback(new Error("两次输入的密码不一致"));
        } else {
          callback();
        }
      },
      submitForm(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            request.post('/user/register', this.ruleForm)
                .then(res => {
                  if (res.data.code === '200') {
                    this.$message.success("注册成功");
                    this.$router.push('/index/login')
                  }else{
                    this.$message.error("注册失败");
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

    }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}
.avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}
.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
}
.avatar {
    width: 178px;
    height: 178px;
    display: block;
}
.el-radio-group{
    float: left;
}
</style>