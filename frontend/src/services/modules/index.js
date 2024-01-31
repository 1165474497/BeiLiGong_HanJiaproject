
import Request from '@/services/request/index.js';
export function getSpeciesApi() {
    return Request.get({
        url: '/material/count/1',
    });
}


export function getItemListApi() {
    return Request.get({
        url: '/material/count/list',
    });
}

export function getTotalApi() {
    return Request.get({
        url: '/material/count',
    });
}

