<template>
  <div style="text-align: center;width: 100%;">

        <el-form :model="form" ref="form" style="width: 100%;" >
          <el-form-item>
              <el-input v-model="form.sysName" placeholder="请输入威胁建模名称" clearable style="width:30%;margin-left: 35%;margin-top: 20px;text-align: center"></el-input>
          </el-form-item>

          <el-form-item
          v-for="(module, index) in form.moduleInfoDTOList"
          :label="'模块' + index"
          :key="module.key"
          :prop="'module.' + index + '.value'"
          >

        <el-input v-model="form.moduleInfoDTOList[index].moduleName" placeholder="请输入模块名称" clearable style="width: 25%;"></el-input>



      <el-select v-model="form.moduleInfoDTOList[index].vulTypeList"  multiple filterable clearable collapse-tags="true"	 placeholder="请选择该模块可能存在的风险" style="width: 65%;">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>

      <el-button type="warning" plain @click.prevent="removeDomain(module)" style="width: 10%;">删除</el-button>


    </el-form-item>

        <el-button type="primary" @click="addDomain" style="width: 15%;">新增模块</el-button>


        <el-button type="primary" @click="save" style="width: 15%;">提交&下载</el-button>

  </el-form>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "WX01",

  data() {
    return {
      form: {
        sysName:'',
        moduleInfoDTOList: [
          {
            moduleName: '',
            vulTypeList: [],
          },
        ]
      },

      options: [],

      value: [],

    }
  },

  created() {
    this.load()
  },

  methods:{
    save(){
      let _this = this;
      console.log(this.form)
      request.post("/user/wx",this.form,{responseType: "blob"}).then(res => {
        const blob = res
        // _this.download(blob, "temp.xlsx")
        _this.download(blob, this.form.sysName+'.xlsx')

      })

    },

    download(blob, fileName){
      // var newBlob = new Blob([blob], {type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8'});
      var newBlob = new Blob([blob], {type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'});
      let blobUrl = window.URL.createObjectURL(newBlob);
      let a = document.createElement("a");
      document.body.appendChild(a);
      a.href = blobUrl;
      a.download = fileName;
      a.click();
      document.body.removeChild(a);
    },

    removeDomain(item) {
      var index = this.form.moduleInfoDTOList.indexOf(item)
      if (index !== -1) {
        this.form.moduleInfoDTOList.splice(index, 1)
      }
    },

    addDomain() {
      this.form.moduleInfoDTOList.push({
        moduleName: '',
        vulTypeList: [],
      });
    },

  //  用于访问页面时，加载漏洞类型数据
    load(){
      request.get("/vultype").then(res => {
        this.options = res.data
      })
    }

  }


}
</script>

<style scoped>

</style>