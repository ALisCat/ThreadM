<template>
  <div>
    <el-row class="tac">
      <el-menu
          style="width: 200px; min-height: calc(100vh - 50px)"
          :default-active="path"
          router
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
      >
        <el-sub-menu index="1">
          <template #title>
            <span>系统管理</span>
          </template>

          <el-menu-item index="/wx01">Threat M</el-menu-item>

        </el-sub-menu>

      </el-menu>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "leftmenutable",

  data(){
      return {
          path: this.$router.patch
      }
  }
}

</script>

<style scoped>

</style>