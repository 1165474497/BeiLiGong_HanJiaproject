<script setup>
import { ref,computed } from 'vue'
let logoText = ref('氟材料展示平台')
let typeList = defineModel()
</script>

<template>
  <el-menu
      router
      class="menu-nav"
      mode="horizontal"
      :ellipsis="false">
    <img class="logo-img" src="@/assets/logo_01.png" alt="logo"/>
    <span class="logo-text">{{ logoText }}</span>
    <div class="flex-grow"/>
    <el-menu-item route="/" index="1">首页</el-menu-item>
    <el-sub-menu index="2">
      <template #title>材料</template>
      <el-menu-item  :route="'/materialList/'+item.id" :index="'2-'+item.id" v-for="item in typeList">{{item['material_type']}}</el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<style>
.flex-grow {
  flex-grow: 1;
}
.menu-nav{
  height: 80px;
  .el-menu-item{
    font-size: 18px;
  }
  .el-sub-menu__title{
    font-size: 18px;
  }
  .el-menu-item__index{
    font-size: 18px;
  }
}
.logo-text{
  margin-top: 20px;
  font-size: 30px;
  margin-left: 10px;
}
.logo-img{
  width: 60px;
  height: 60px;
  margin-top: 10px;
  margin-left: 10px;
}
</style>