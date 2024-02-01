<script setup>
import {ref, onMounted, watch} from "vue";
import {onBeforeRouteUpdate, useRoute, onBeforeRouteLeave} from "vue-router";
import {getMaterialListPageApi, getMaterialTotalApi} from "@/services/modules/index.js";
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
  pageSize.value = val;
  getChemistryList()
}
let handleCurrentChange = (val) => {
  page.value = val;
  getChemistryList()
}

// -------------- 分页处理 --------------
onMounted(() => {
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
})
onBeforeRouteUpdate((to, from, next) => {
  console.log(to)
  let basePath = String(to.path).split('/')[1];
  if ('materialList' === basePath) {
    search.value = '';
    typeId.value = to.params.id;
    // getChemistryList()
    // getMaterialTotal(typeId.value)
  } else {
    isSearch.value = true;
    search.value = to.params.key;
  }
  next()
})
onBeforeRouteLeave((to, from, next) => {
  let basePath = String(to.path).split('/')[1];
  if ('materialList' === basePath) {
    search.value = '';
    typeId.value = to.params.id;
    // getChemistryList()
    // getMaterialTotal(typeId.value)
  } else {
    isSearch.value = true;
    search.value = to.params.key;
  }
  next()
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
  router.push(`/materialSearch/${search.value}`)
}
watch(typeId, () => {
  getChemistryList()
  getMaterialTotal(typeId.value)
})

</script>

<template>
  <el-scrollbar ref="scroll" class="chemistry-list">
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
    <div class="no-data" v-if="data.chemistryList.length===0">
      <el-alert title="暂无数据，请更换材料种类或搜索关键词" type="error" :closable="false" show-icon/>
    </div>

    <div v-else class="total-show">
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

.chemistry-list {
  margin: auto;
  width: 80%;
  background-color: rgba(255, 255, 255, 0.8);

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
  height: 50px;

  .el-alert {
    height: 50px;
  }
}
</style>