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
      title="编辑功能导航"
      :visible.sync="drawer"
      :with-header="false"
      size="65%"
    >
      <span>我来啦!</span>
    </el-drawer>

    <el-card class="box-card" shadow="hover">
      <div slot="header" class="clearfix">
        <span>功能导航</span>
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
      <el-table :data="tableData" style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="商品名称">
                <span>{{ props.row.name }}</span>
              </el-form-item>
              <el-form-item label="所属店铺">
                <span>{{ props.row.shop }}</span>
              </el-form-item>
              <el-form-item label="商品 ID">
                <span>{{ props.row.id }}</span>
              </el-form-item>
              <el-form-item label="店铺 ID">
                <span>{{ props.row.shopId }}</span>
              </el-form-item>
              <el-form-item label="商品分类">
                <span>{{ props.row.category }}</span>
              </el-form-item>
              <el-form-item label="店铺地址">
                <span>{{ props.row.address }}</span>
              </el-form-item>
              <el-form-item label="商品描述">
                <span>{{ props.row.desc }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column label="商品 ID" prop="id" />
        <el-table-column label="商品名称" prop="name" />
        <el-table-column label="描述" prop="desc" />
      </el-table>
      <el-pagination background layout="prev, pager, next" :total="1000" />
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'MenuFunManagement',
  data() {
    return {
      drawer: false,
      table: false,
      dialog: false,
      loading: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '80px',
      timer: null,
      tableData: [
        {
          id: '12987122',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        },
        {
          id: '12987123',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        },
        {
          id: '12987125',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        },
        {
          id: '12987126',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }
      ]
    }
  },
  computed: {
    message() {
      return ''
    }
  },
  methods: {
    handleClose(done) {
      if (this.loading) {
        return
      }
      this.$confirm('确定要提交表单吗？')
        .then(_ => {
          this.loading = true
          this.timer = setTimeout(() => {
            done()
            // 动画关闭需要一定的时间
            setTimeout(() => {
              this.loading = false
            }, 400)
          }, 2000)
        })
        .catch(_ => {})
    },
    cancelForm() {
      this.loading = false
      this.dialog = false
      clearTimeout(this.timer)
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
