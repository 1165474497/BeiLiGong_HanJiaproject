<script setup>

import HeaderNav from "@/components/currency/HeaderNav.vue";
import {getItemListApi, getMaterialTypeListApi} from "@/services/modules/index.js";
import {ref, onMounted} from "vue";
import router from "@/routers/index.js";
let data = ref({
  typeList: [],
  itemList: []
});
async function getTypeList(){
  const res = await getMaterialTypeListApi();
  data.value.typeList = res.data;
}
async function getItemList(){
  const res = await getItemListApi();
  data.value.itemList = res.data;
}
onMounted(()=>{
  getTypeList()
  getItemList()
})
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header class="header-nav">
        <HeaderNav v-model="data.typeList"></HeaderNav>
      </el-header>
      <el-main class="main">
        <router-view v-model:itemList="data.itemList" v-slot="{ Component }">
          <transition>
            <component :is="Component" />
          </transition>
        </router-view>
      </el-main>
    </el-container>
  </div>
</template>

<style>
.header-nav{
  width: 100%;
}
.common-layout{
  width: 100%;
  height: 100%;
  .el-header{
    padding: 0;
  }
  .el-main{
    margin-top: 20px;
    padding: 0;
  }
  .main{
    height: Calc(100vh - 80px);
    overflow: auto;

    background: linear-gradient(to bottom, rgba(108, 129, 154, 0.5),rgba(17,46,81,.5)),url("@/assets/indexPic/background.png"),linear-gradient(to bottom,#20558a, #5c7b9f);
    background-repeat: no-repeat;
    background-size: 100% 100%;
    background-position: center;

  }
}
</style>