
import Request from '@/services/request/index.js';
export function getSpeciesApi() {
    return Request.get({
        url: '/material/count/1',
    });
}




