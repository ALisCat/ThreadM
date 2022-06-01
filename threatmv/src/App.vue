<template>
  <!--  router作为全局的根节点访问,routerview 里面可以有登录、注册、后台主体，会根据路由进行展示，当访问主体内容的时，进行一个二次的路由认证-->
  <div>
    <router-view/>
  </div>

</template>

<script>
export default {
  name:"App"
}
</script>
