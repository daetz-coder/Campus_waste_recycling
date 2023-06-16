<template>
    <div>
        <el-upload
                class="avatar-uploader"
                :action="uploadUrl"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                :headers="headers">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
    </div>
</template>

<script>
export default {
  name: 'TestForAvatar',
  data() {
    return {
      imageUrl: '',
      uploadUrl: 'http://localhost:8081/file/upload/img',
      token: '',
      headers: {
        'token': ''
      }
    };
  },
  methods: {
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
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
    }
  },
  mounted() {
    // 从本地存储中获取 token
    this.token = localStorage.getItem('username') ? JSON.parse(localStorage.getItem('username')).token : '';
    // 设置请求头中的 token
    this.headers.token = this.token;
  }
}
</script>

<style scoped>
.avatar-uploader {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 120px;
    height: 120px;
    border: 1px solid #d9d9d9;
    overflow: hidden;
}

.avatar {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.avatar-uploader-icon {
    font-size: 36px;
    color: #8c939d;
}
</style>
