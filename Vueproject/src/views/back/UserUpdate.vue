<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <!--            id主键自增-->
            <el-form-item label="用户名" prop="username">
                <el-input v-model="ruleForm.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="ruleForm.password"></el-input>
            </el-form-item>
            <el-form-item label="昵称" prop="nickname">
                <el-input v-model="ruleForm.nickname"></el-input>
            </el-form-item>
            <el-form-item label="头像" prop="avatar">
                <el-input v-model="ruleForm.avatar"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
                <el-input v-model="ruleForm.sex"></el-input>
            </el-form-item>
            <el-form-item label="生日" prop="birthday">
                <el-input v-model="ruleForm.birthday"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="ruleForm.email"></el-input>
            </el-form-item>
            <el-form-item label="权限" prop="role">
                <el-input v-model="ruleForm.role"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import request from "@/utils/request";

export default {
  name:'UserUpdate',
  data() {
    return {
      ruleForm: {
        username:'',
        password:'',
        nickname:'',
        avatar:'',
        sex:'',
        birthday:'',
        email:'',
        role:'',
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },// blur失去焦点触发
        ],
        password: [
          { required: true, message: '请输入用户密码', trigger: 'blur' },
        ],
        nickname: [
          { required: true, message: '请输入用户昵称', trigger: 'blur' },
        ],
        avatar: [
          { required: true, message: '请输入用户头像', trigger: 'blur' },
        ],
        sex: [
          { required: true, message: '请输入用户性别', trigger: 'blur' },
        ],
        birthday: [
          { required: true, message: '请输入用户生日', trigger: 'blur' },
        ],
        email: [
          { required: true, message: '请输入用户邮箱', trigger: 'blur' },
        ],
        role: [
          { required: true, message: '请输入用户权限', trigger: 'blur' },
        ],

      }
    };
  },
  methods: {
    test(){
      console.log(this.ruleForm)
    },
    submitForm(formName) {
      const _this=this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8081/admin/update',this.ruleForm).then(function (resp){
            if(resp.data='true'){
              alert("用户修改成功")
              // _this.$message('用户登录成功')
            }else{
              alert("用户修改失败")
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].$refs.tableFrom.resetFields();
    },
  },
  created(){
    const _this=this
    request.get('http://localhost:8081/admin/findById/'+this.$route.query.id).then(function (resp){
      _this.ruleForm=resp.data
      console.log(resp)
      //axios.get('http://localhost:8081/admin/findById/'+this.$route.query.id).then(resp => {
      //  this.ruleForm = resp.data
      //})
  })
    //获取参数使用route，路径选择router
  }
}
</script>

<style scoped>
.el-form{
    text-align: left;
}
</style>