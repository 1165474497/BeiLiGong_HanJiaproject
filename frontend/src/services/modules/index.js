
import Request from '@/services/request/index.js';


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

export function getMaterialTypeListApi() {
    return Request.get({
        url: '/materialtype/all',
    });
}

export function getMaterialTypeListByIdApi(id) {
    return Request.get({
        url: `/material/type/${id}`,
    });
}

export function getMaterialTotalApi(id) {
    return Request.get({
        url: `/material/count/${id}`,
    });
}

export function getMaterialListPageApi(id ,page, size) {
    return Request.post({
        url: `/material/type/${id}`,
        data: {
            page: page,
            size: size
        }
    });
}

export function getMaterialListPageBySearchApi(key ,page, size) {
    return Request.post({
        url: `/material/search/pagination`,
        data: {
            keyword: key,
            page: page,
            size: size
        }
    });
}