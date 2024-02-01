<script setup>
import {useRoute} from "vue-router";
import {ref, onMounted} from "vue";
import {getMaterialInfoApi, getMaterialListPageBySearchApi} from "@/services/modules/index.js";
import {BASE_URL} from "@/services/request/config.js";
import router from "@/routers/index.js";
const {path, params} = useRoute();
let cas = ref(params.cas);
let data = ref({});
let base_info = ref({});
let itemList = defineModel('itemList');
async function getMaterial() {
  const res = await getMaterialListPageBySearchApi(cas.value, 1, 1);
  base_info.value = res.data[0];

}
async function getMaterialInfo() {
  const res = await getMaterialInfoApi(cas.value);
  data.value = res.data;
  console.log(data.value)
}
let loading = ref(true)
onMounted(() => {
  loading.value = true
  getMaterialInfo()
  getMaterial()
  loading.value = false
})
</script>

<template>
  <el-scrollbar>
    <el-container>
      <el-aside class="aside-bar">
        <el-card  v-loading="loading" :header="base_info['name_zh']">
          <el-image  :src="BASE_URL+`/static/diagram/${cas}.png`" class="image" alt="" >
            <template #error>
              <el-empty :image-size="100" description="暂无图片"></el-empty>
            </template>
          </el-image>
          <div class="bottom clearfix">
            <el-descriptions :column="1">
              <el-descriptions-item label="CAS号:">{{base_info['cas']}}</el-descriptions-item>
              <el-descriptions-item label="材料种类:">{{base_info['material_type']}}</el-descriptions-item>
              <el-descriptions-item label="简称:">{{base_info['abbreviation']}}</el-descriptions-item>
              <el-descriptions-item label="分子式:">{{base_info['molecular_formula']}}</el-descriptions-item>
              <el-descriptions-item label="分子量:">{{base_info['molecular_weight']}}</el-descriptions-item>
            </el-descriptions>
          </div>
        </el-card>
        <el-card  v-loading="loading" header="材料导航" style="margin-top: 20px">
          <el-button size="large" style="margin-bottom: 5px" link v-for="i in itemList" @click="router.push(`/materialList/${i.id}`)">
            <el-tag>{{ i['name'] }}</el-tag>
          </el-button>
        </el-card>
      </el-aside>
      <el-main>
        <div  v-loading="loading" class="material-info">

          <el-descriptions v-if="data!==null" border :column="1">
            <el-descriptions-item v-for="(v) in data" :label="v['name']">
              <span style="width: 100%" v-for="i in v['value']">{{i}}</span>
            </el-descriptions-item>
          </el-descriptions>
          <el-empty v-else description="暂无数据"></el-empty>
        </div>
      </el-main>
    </el-container>
  </el-scrollbar>

</template>

<style>
.material-info {
  width: 90%;
  margin: auto;
  border-radius: 5px;
  padding: 5px;
  background-color: rgba(255, 255, 255, 0.8);
  .el-descriptions__label{
    font-weight: bold;
  }
}
.aside-bar{
  width: 20%;
  margin-top: 20px;
  margin-left: 10%;
  .el-card__header{
    font-size: 20px;
    font-weight: bold;
  }
  .image{
    width: 100%;
    height: 100%;
  }
  .bottom{
    margin-top: 10px;
    .el-button{
      margin-right: 10px;
    }
  }
  .el-descriptions__label{
    font-weight: bold;
  }
}
</style>