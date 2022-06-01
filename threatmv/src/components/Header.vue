<template>
  <div style="height: 50px; line-height: 50px; border-bottom: 1px  solid aqua; display: flex">
      <!--   右边标题   -->
      <div style="width: 200px; padding-left: 30px; font-weight: bold; color: dodgerblue">demo</div>

      <div style="flex: 1"></div>

      <!--  左边下拉菜单  -->
      <div style="width: 100px; padding-top: 15px">
        <el-dropdown>
            <span class="el-dropdown-link">
              <el-icon class="el-icon--right ">
                <arrow-down />
                admin
              </el-icon>
            </span>
                  <template #dropdown>
                    <el-dropdown-menu>
                      <el-dropdown-item>个人信息</el-dropdown-item>
                      <el-dropdown-item divided>密码重置</el-dropdown-item>
                      <el-dropdown-item divided @click="$router.push('/login')">退出系统</el-dropdown-item>
                    </el-dropdown-menu>
                  </template>
        </el-dropdown>
      </div>
  </div>
</template>

<script>
export default {
  name: "Header"
}


</script>



<style scoped>

</style>