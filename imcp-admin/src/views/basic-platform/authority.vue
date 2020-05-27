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
      title="编辑权限信息"
      :visible.sync="drawer"
      :with-header="false"
      size="65%"
    >
      <span>我来啦!</span>
    </el-drawer>
    <!--
    <div class="buttons">
      <el-button @click="dialogFormVisible = true">编辑组织</el-button>
      <el-button @click="getCheckedNodes">通过 node 获取</el-button>
      <el-button @click="getCheckedKeys">通过 key 获取</el-button>
      <el-button @click="setCheckedNodes">通过 node 设置</el-button>
      <el-button @click="setCheckedKeys">通过 key 设置</el-button>
      <el-button @click="resetChecked">清空</el-button>
    </div>
    -->
    <el-card class="box-card" shadow="hover">
      <div style="width: 320px">
        <el-input v-model="filterText" placeholder="输入关键字进行过滤">
          <i slot="prefix" class="el-input__icon el-icon-search" />
        </el-input>
      </div>
      <div slot="header" class="clearfix">
        <span>权限管理</span>
        <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
      </div>
      <el-tree
        ref="tree"
        :filter-node-method="filterNode"
        :data="data"
        show-checkbox
        default-expand-all
        class="filter-tree"
        node-key="id"
        highlight-current
        :props="defaultProps"
      />
    </el-card>
  </div>
</template>
<script>
export default {
  name: 'AuthManagement',
  data() {
    return {
      filterText: '',
      table: false,
      drawer: false,
      timer: null,
      data: [
        {
          id: 1,
          label: '一级 1',
          children: [
            {
              id: 4,
              label: '二级 1-1',
              children: [
                {
                  id: 9,
                  label: '三级 1-1-1'
                },
                {
                  id: 10,
                  label: '三级 1-1-2'
                }
              ]
            }
          ]
        },
        {
          id: 2,
          label: '一级 2',
          children: [
            {
              id: 5,
              label: '二级 2-1'
            },
            {
              id: 6,
              label: '二级 2-2'
            }
          ]
        },
        {
          id: 3,
          label: '一级 3',
          children: [
            {
              id: 7,
              label: '二级 3-1'
            },
            {
              id: 8,
              label: '二级 3-2'
            }
          ]
        }
      ],
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  computed: {
    message() {
      return ''
    }
  },
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val)
    }
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    getCheckedNodes() {
      console.log(this.$refs.tree.getCheckedNodes())
    },
    getCheckedKeys() {
      console.log(this.$refs.tree.getCheckedKeys())
    },
    setCheckedNodes() {
      this.$refs.tree.setCheckedNodes([
        {
          id: 5,
          label: '二级 2-1'
        },
        {
          id: 9,
          label: '三级 1-1-1'
        }
      ])
    },
    setCheckedKeys() {
      this.$refs.tree.setCheckedKeys([3])
    },
    resetChecked() {
      this.$refs.tree.setCheckedKeys([])
    }
  }
}
</script>

<style lang='scss' scoped>
.base-div {
  margin: 10px;
}
.text {
  font-size: 14px;
}
.item {
  padding: 18px 0;
}
.box-card {
  width: 100%;
}
</style>
