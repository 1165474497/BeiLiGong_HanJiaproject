<script setup>
import Container from '../Container/index.vue'

// const routes = [
//   {
//     path: '/',
//     name: '首页',
//   },
//   {
//     path: '/persons',
//     name: '人员列表',
//   },
//   {
//     path: '/institution',
//     name: '机构列表',
//   },
//   {
//     path: '/paper_list',
//     name: '论文列表',
//   },
// ]
</script>

<template>
  <div class="header">

    <nav>
      <ul style="background-color: #43759c;height: 10px"></ul>

      <container>
        <ul>

          <li class="iconStyle">
            <img src="@/assets/logo.svg" alt="" style="width:100px; height:100px; padding-right: 20px">
            <img src="@/assets/logo_02.svg" alt="" style="width:200px; height:100px; padding-right: 20px">
<!--            <el-text style="justify-content: center; text-align: center;font-size: 24px">北京理工大学</el-text>-->
          </li>

<!--          <li v-for="(route, index) in routes" :key="index" class="routeSelect">-->
<!--            <router-link :to="route.path" active-class="active">-->
<!--              {{ route.name }}-->
<!--            </router-link>-->
<!--          </li>-->
        </ul>
      </container>


    </nav>
  </div>
</template>

<style scoped>


nav {
  background-color: rgb(241, 241, 241);
  box-shadow: 0 10px 20px rgba(0, 0, 0, .3);
}

nav ul {
  all: unset;
  display: flex;
  height: auto;
}

nav ul li {
  color: black;
  width: 120px;
  display: flex;
  cursor: pointer;
}

nav ul li:hover {
  background-color: #43759c;
}

nav ul li a {
  all: unset;
  padding: 16px 0;
  width: 100%;
  font-weight: 700;
  font-size: 16px;
  text-align: center;
}


.iconStyle {
  color: black;
  width: 360px;
  display: flex;

  padding-top: 10px;
  padding-bottom: 10px;

  &:hover {
    background-color: transparent;
    cursor: default;
  }
}


</style>
