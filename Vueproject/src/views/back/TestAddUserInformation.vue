<template>
    <div ref="canvasWrapper">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="ruleForm.username"></el-input>
            </el-form-item>
            <el-form-item label="头像" prop="avatar">
                <el-upload
                        class="avatar-uploader"
                        action="/api/upload"
                        :show-file-list="false"
                        :before-upload="beforeAvatarUpload"
                        :on-success="handleUploadSuccess"
                        :file-list="fileList">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
                <el-input v-model="ruleForm.avatar" placeholder="头像地址"></el-input>
            </el-form-item>

        </el-form>
    </div>
</template>
<script>
import request from "@/utils/request";
export default {
  name:'TestAddUserInformation',
  data() {
    return {
      imageUrl: '',
      fileList: [],
      uploadUrl: "/api/upload",
      ruleForm: {
        username:'',
        avatar:'',
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },// blur失去焦点触发
        ],
        avatar: [
          { required: true, message: '请输入用户头像', trigger: 'blur' },
        ],
      }
    };
  },
  methods: {
    handleUploadSuccess(response, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
      this.ruleForm.avatar = `path/to/save/files/${file.name}`;
      console.log("upload success: ", response);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },
    test(){
      console.log(this.ruleForm)
    },
    submitForm(formName) {
      const _this=this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request.post('http://localhost:8081/admin/save',this.ruleForm).then(function (resp){
            if(resp.data='true'){
               alert("用户添加成功")
              // _this.$message('用户登录成功')
            }else{
              alert("用户天添加失败")
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.el-form{
    text-align: left;
}
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
</style>