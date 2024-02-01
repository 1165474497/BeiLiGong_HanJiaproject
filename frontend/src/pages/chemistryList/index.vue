<script setup>
import {ref, onMounted, watch} from "vue";
import {onBeforeRouteUpdate, useRoute, onBeforeRouteLeave} from "vue-router";
import {getMaterialListPageApi, getMaterialListPageBySearchApi, getMaterialTotalApi} from "@/services/modules/index.js";
import ItemCard from "@/components/chemistryList/ItemCard.vue";
import {Search} from "@element-plus/icons-vue";
import router from "@/routers/index.js";

let isSearch = ref(false);
let typeId = ref(1);
const {path, params} = useRoute();
let search = ref('');
let data = ref({
  chemistryList: []
})

// 获取材料列表
async function getChemistryList() {
  const res = await getMaterialListPageApi(typeId.value, page.value, pageSize.value);
  data.value.chemistryList = res.data;
}

// 获取材料总数 用于分页
async function getMaterialTotal(id) {
  let res = await getMaterialTotalApi(id);
  total.value = res.data;
}

// -------------- 分页处理 --------------
let page = ref(1);
let pageSize = ref(5)
let total = ref(1)
let handleSizeChange = (val) => {
  loading.value = true
  pageSize.value = val;
  if (isSearch.value) {
    getMaterialListBySearch()
  } else {
    getChemistryList()
  }
  loading.value = false
}
let handleCurrentChange = (val) => {
  loading.value = true
  page.value = val;
  if (isSearch.value) {
    getMaterialListBySearch()
  } else {
    getChemistryList()
  }
  loading.value = false
}

// -------------- 分页处理 --------------
onMounted(() => {
  loading.value = true
  let basePath = path.split('/')[1];
  if ('materialList' === basePath) {
    search.value = '';
    typeId.value = params.id;
    getChemistryList()
    getMaterialTotal(typeId.value)

  } else {
    isSearch.value = true;
    search.value = params.key;
  }
  loading.value = false
})
onBeforeRouteUpdate((to, from, next) => {
  loading.value = true
  let basePath = String(to.path).split('/')[1];
  if ('materialList' === basePath) {
    search.value = '';
    typeId.value = to.params.id;
  } else {
    isSearch.value = true;
    search.value = to.params.key;
    getMaterialListBySearch()
  }
  next()
  loading.value = false
})
onBeforeRouteLeave((to, from, next) => {
  loading.value = true
  let basePath = String(to.path).split('/')[1];
  if ('materialList' === basePath) {
    search.value = '';
    typeId.value = to.params.id;
  } else {
    isSearch.value = true;
    search.value = to.params.key;
    getMaterialListBySearch()
  }
  next()
  loading.value = false
})
// -------------- 搜索处理 --------------

let handleSearch = () => {
  if (search.value === '') {
    ElNotification({
      title: '搜索内容不能为空',
      message: '请输入搜索内容',
      type: 'warning'
    })
    return;
  }
  loading.value = true
  router.push(`/materialSearch/${search.value}`)
  getMaterialListBySearch()
  loading.value = false
}
watch(typeId, () => {
  loading.value = true
  getChemistryList()
  getMaterialTotal(typeId.value)
  loading.value = false
})
let loading = ref(true)
async function getMaterialListBySearch() {
  loading.value = true
  let res = await getMaterialListPageBySearchApi(search.value, page.value, pageSize.value);
  total.value = Number(res.message);
  isSearch.value = true;
  data.value.chemistryList = res.data;
  loading.value = false
}

let itemList = defineModel('itemList');
</script>

<template>

  <el-scrollbar>

    <el-container>

      <el-main>
        <div v-loading="loading" class="chemistry-list" >
          <div class="search-input-background">
            <div class="search-input">
              <el-form label-position="top">
                <el-form-item label="搜索材料...">
                  <el-input v-model="search" placeholder="请输入关键词">
                    <template #append>
                      <el-button @click="handleSearch" :icon="Search" style="width: 60px"></el-button>
                    </template>
                  </el-input>
                </el-form-item>
              </el-form>
            </div>
          </div>
          <transition>
            <div class="no-data" v-if="total===0">
              <el-empty description="暂无数据，请更换材料种类或搜索关键词"></el-empty>
            </div>
          </transition>
          <transition>
            <div>
              <div  v-if="total!==0" class="total-show">
                <el-text tag="b" style="text-align: center;margin-top: 20px ">
                  共{{ total }}条数据
                </el-text>

              </div>
              <ItemCard v-model:itemList="data.chemistryList"></ItemCard>
              <el-pagination
                  class="item-pagination"
                  v-model:current-page="page"
                  v-model:page-size="pageSize"
                  :page-sizes="[5, 10]"
                  layout="total, sizes, prev, pager, next, jumper"
                  :total="total"
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :hide-on-single-page="true"
              />
            </div>
          </transition>
          <br>
        </div>
      </el-main>
      <el-aside class="aside-nav">
        <el-card header="材料导航" style="margin-top: 20px">
          <el-button size="large" style="margin-bottom: 5px" link v-for="i in itemList"
                     @click="router.push(`/materialList/${i.id}`)">
            <el-tag>{{ i['name'] }}</el-tag>
          </el-button>
        </el-card>
      </el-aside>
    </el-container>

  </el-scrollbar>

</template>

<style>
.el-pagination {
  justify-content: center;
  padding-bottom: 50px;
}

.item-pagination {


  margin: 0 auto 50px auto;
  display: flex;
  width: 60%;

  padding: 0 25px 0 25px;
  align-items: center;

  font-weight: bold;


}

.aside-nav {
  width: 20%;
  margin-top: 20px;
  margin-right: 10%;

  .el-card__header {
    font-size: 20px;
    font-weight: bold;
  }
}

.chemistry-list {
  border-radius: 5px;
  margin: auto;
  width: 90%;
  background-color: rgba(255, 255, 255, 0.92);

  .search-input-background {
    width: 100%;
    border-bottom: #20558a 2px solid;

    .search-input {
      padding: 30px;
      width: 65%;
      margin: 0 auto;


      .el-input {
        height: 60px;
        margin: 0 auto;

        .el-button {
          background: white;
          height: 60px;
        }

        .el-icon,
        .el-button svg {
          width: 25px;
          height: 25px;
          color: rgb(0, 113, 188);

        }
      }
    }

    .el-input:hover {
      box-shadow: #d6d7d9 0 0 10px;
    }
  }

  .total-show {
    width: 60%;
    margin: 30px auto 20px auto;

    .el-text {
      width: 50%;
    }

    .sort-select {
    }
  }
}

.no-data {
  width: 60%;
  margin: 30px auto 20px auto;
}
</style>