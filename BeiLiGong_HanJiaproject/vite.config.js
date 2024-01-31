import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

import {fileURLToPath, URL} from 'node:url';
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'


// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue(),
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        }),
    ],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url)),
        },
    },

    build: {
        minify: 'terser', // 启用 terser 压缩
        terserOptions: {
            compress: {
                pure_funcs: ['console.log'], // 只删除 console.log
                drop_debugger: true, // 删除 debugger
            }
        }
    },
    server: {
        proxy: {
            // 字符串简写写法：http://localhost:5173/foo -> http://localhost:4567/foo
            // 带选项写法：http://localhost:5173/api/bar -> http://jsonplaceholder.typicode.com/bar
            // http://10.10.4.40:5000 场景二  http://127.0.0.1:5000
            '/api': {
                target: 'http://127.0.0.1:8080',
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, ''),
            },

        },
    },
})
