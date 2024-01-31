<script setup>
import router from "@/routers/index.js";

let data = defineModel("itemList")
import {BASE_URL} from "@/services/request/config.js";
</script>

<template>
  <div class="item-list">
    <div class="item-list-card" v-for="item in data">
      <div class="item-image">
        <el-image :src="BASE_URL+`/static/diagram/${item['cas']}.png`" fit="fill"></el-image>
      </div>
      <div class="item-info">
        <el-descriptions
          :bordered="true"
          :column="1"
          :title="item['name_cn']"
        >
          <el-descriptions-item  label="名称">{{item['name_zh']}}</el-descriptions-item>
          <el-descriptions-item label="CAS号">{{item['cas']}}</el-descriptions-item>
          <el-descriptions-item label="材料种类">{{item['material_type']}}</el-descriptions-item>
          <el-descriptions-item label="简称">{{item['abbreviation']}}</el-descriptions-item>
          <el-descriptions-item label="分子式">{{item['molecular_formula']}}</el-descriptions-item>
          <el-descriptions-item label="分子量">{{item['molecular_weight']}}</el-descriptions-item>
        </el-descriptions>
        <el-button link @click="router.push(`/material/${item.id}`)">查看更多</el-button>
      </div>

    </div>
  </div>

</template>

<style>
.item-list-card{
  background: #ffffff;
  margin: 2% auto;
  width: 60%;
  border: solid 1px #d6d7d9;
  border-radius: 5px;
  display: flex;
  flex-wrap: wrap;
  padding: 25px;
  justify-content: flex-start;
  .el-image{

    height: 200px;
  }
  .item-info{
    width: 70%;
    margin-left: 20px;
    .el-descriptions__label{
      font-weight: bold;
    }
  }
}
</style>