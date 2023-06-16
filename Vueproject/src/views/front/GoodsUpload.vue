<template>
    <div class="upload-page">
        <el-form ref="uploadForm" :model="form" label-width="120px" enctype="multipart/form-data">
            <el-form-item label="商品名称">
                <el-input v-model="form.name"></el-input>
            </el-form-item>

            <el-form-item label="价格">
                <el-input v-model="form.price"></el-input>
            </el-form-item>

            <el-form-item label="图片链接">
                <el-input v-model="form.imageUrl"></el-input>
            </el-form-item>

            <el-form-item label="描述">
                <el-input v-model="form.description" type="textarea"></el-input>
            </el-form-item>

            <el-form-item label="数量">
                <el-input v-model="form.store"></el-input>
            </el-form-item>

            <el-form-item label="分类">
                <el-select v-model="form.categoryId">
                    <el-option label="电脑" value="1"></el-option>
                    <el-option label="手机" value="2"></el-option>
                    <el-option label="平板" value="3"></el-option>
                    <el-option label="面包" value="4"></el-option>
                    <el-option label="牛奶" value="5"></el-option>
                    <el-option label="饮料" value="6"></el-option>
                    <el-option label="教材" value="7"></el-option>
                    <el-option label="人文" value="8"></el-option>
                    <el-option label="艺术" value="9"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="使用年限">
                <el-input v-model="form.usedYear"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm">提交</el-button>
                <el-button @click="resetForm">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name:'GoodsUpload',
  data() {
    return {
      form: {
        name: '',
        price: '',
        imageUrl: '',
        description: '',
        categoryId: '',
        store:'',
        sale:'0',
        usedYear:'',
        state:'0',
      },
    };
  },
  methods: {
    submitForm() {
      request.post("/goods/saveOrUpdate", this.form)
        .then(resp => {
          console.log(resp.data)
          if (resp.data.code === "200") {
            this.$message.success("上传成功，等待管理员审核！");
          } else {
            this.$message.error("上传失败！");
          }
        });
      // 清空表单
      this.$refs.uploadForm.resetFields();
    },
    resetForm() {
      this.$refs.uploadForm.resetFields();
    },
  },
};
</script>

<style scoped>
.upload-page {
    max-width: 500px;
    margin: 0 auto;
    padding: 20px;
}
</style>
