<script setup>
import {defineModel} from "vue";
import TypeInfoCard from "@/components/home/TypeInfoCard.vue";

let typeList = defineModel("itemList")
</script>

<template>
  <div class="home">
    <h1>氟材料数据展示平台</h1>
    <TypeInfoCard class="type-info-card" v-model="typeList"></TypeInfoCard>
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
  }
}
</style>