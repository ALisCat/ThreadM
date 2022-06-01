<template>
  <nav>
    <!-- 头部 -->
    <Header></Header>

    <!--  主体  -->
    <div style="display: flex">
      <!--   左侧边栏   -->
      <leftmenutable></leftmenutable>
      <!--   内容区域   -->
      <router-view/>
    </div>

  </nav>
</template>

<script>
import Header from "@/components/Header";
import leftmenutable from "@/components/leftmenutable";

export default {
  name: "Layout",
  components:{
    Header,
    leftmenutable

  }
}
</script>

<style scoped>

</style>