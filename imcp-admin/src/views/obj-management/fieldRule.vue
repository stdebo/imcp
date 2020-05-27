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
    <el-drawer title="编辑规则字段" :visible.sync="drawer" :with-header="false" size="65%">
      <span>我来啦!</span>
    </el-drawer>

    <el-card class="box-card" shadow="hover">
      <div slot="header" class="clearfix">
        <span>规则字段</span>
        <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
      </div>
      <div style="width: 320px">
        <el-input v-model="input3" placeholder="请输入内容" class="input-with-select">
          <el-select slot="prepend" v-model="select" placeholder="请选择">
            <el-option label="aaaa" value="1" />
            <el-option label="bbbb" value="2" />
            <el-option label="cccc" value="3" />
          </el-select>
          <el-button slot="append" icon="el-icon-search" />
        </el-input>
      </div>
      <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55" />
        <el-table-column label="日期" width="120">
          <template slot-scope="scope">{{ scope.row.date }}</template>
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120" />
        <el-table-column prop="address" label="地址" show-overflow-tooltip />
      </el-table>
      <div style="margin-top: 20px">
        <el-button @click="toggleSelection([tableData[1], tableData[2]])">第二、第三行的选中</el-button>
        <el-button @click="toggleSelection()">取消选择</el-button>
      </div>
      <el-pagination background layout="prev, pager, next" :total="1000" />
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'FieldRule',
  data() {
    return {
      drawer: false,
      table: false,
      dialog: false,
      loading: false,
      formLabelWidth: '80px',
      timer: null,
      tableData: [
        {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-08',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-06',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-07',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }
      ],
      multipleSelection: []
    }
  },
  computed: {
    message() {
      return ''
    }
  },
  methods: {
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val
    }
  }
}
</script>

<style lang="scss" scoped>
.base-div {
  margin: 10px;
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>
