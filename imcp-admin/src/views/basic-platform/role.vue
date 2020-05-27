<template>
  <div class="base-div">
    <el-button-group>
      <el-tooltip :disabled="disabled" content="新增" placement="bottom">
        <el-button type="primary" icon="el-icon-circle-plus" @click="drawer = true" />
      </el-tooltip>
      <el-tooltip :disabled="disabled" content="修改" placement="bottom">
        <el-button type="primary" icon="el-icon-edit-outline" />
      </el-tooltip>
      <el-tooltip :disabled="disabled" content="删除" placement="bottom">
        <el-button type="primary" icon="el-icon-delete" />
      </el-tooltip>
      <el-button type="primary" icon="el-icon-setting">设置</el-button>
      <el-button type="primary" icon="el-icon-s-unfold">配置</el-button>
    </el-button-group>
    <el-drawer
      title="编辑角色信息"
      :visible.sync="drawer"
      :with-header="false"
      size="65%"
    >
      <span>我来啦!</span>
    </el-drawer>
    <el-card class="box-card" shadow="hover" />
  </div>
</template>

<script>
export default {
  name: 'RoleManagement',
  data() {
    return {
      drawer: false
    }
  },
  computed: {
    message() {
      return ''
    }
  },
  methods: {
  }
}
</script>

<style lang="scss" scoped>
.base-div {
  margin: 10px;
}
</style>
