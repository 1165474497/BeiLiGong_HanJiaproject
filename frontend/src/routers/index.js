import {createRouter, createWebHashHistory} from 'vue-router';

const routes = [
    {
        path: '/',
        name: 'HomeLayout',
        component: () => import('@/layouts/HomeLayout.vue'),
        children: [
            {
                path: '/',
                name: 'HomePage',
                component: () => import('@/pages/home/index.vue'),
            },{
                path: '/materialList/:id',
                name: 'MaterialListPage',
                component: () => import('@/pages/chemistryList/index.vue'),
            },{
            path: '/materialSearch/:key',
            name: 'MaterialSearchPage',
            component: () => import('@/pages/chemistryList/index.vue'),
            }
        ]
    },

    {
        path: '/:pathMatch(.*)*',
        component: () => import('@/pages/404/index.vue'),
    },
];
const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;

