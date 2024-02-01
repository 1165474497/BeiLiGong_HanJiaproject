<script setup>
import {defineModel} from "vue";
import TypeInfoCard from "@/components/home/TypeInfoCard.vue";

let typeList = defineModel("itemList")
</script>

<template>
  <div class="home">
    <el-scrollbar>
      <h1>氟材料数据展示平台</h1>
      <TypeInfoCard class="type-info-card" v-model="typeList"></TypeInfoCard>
    </el-scrollbar>
  </div>
</template>

<style scoped>
.type-info-card {
  width: 80%;
  height: 80%;
  margin: 5% auto;
}
.home{
  h1{
    text-align: center;
    font-size: 50px;
    margin-top: 2%;
    color: #EEEEEE;
  }
  .el-scrollbar{
    height: Calc(100vh - 80px);
  }
}
</style>