import {createApp} from 'vue'
import 'normalize.css'
import '@/assets/styles/index.scss'
import './style.css'
import App from './App.vue'
import router from "./routers/index.js";
import pinia from '@/stores/index.js';

const app = createApp(App);

app.use(router)
app.use(pinia).mount('#app');
document.title = 'XXX';