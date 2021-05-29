import superagentPromise from 'superagent-promise';
import _superagent from 'superagent';

const superagent = superagentPromise(_superagent, global.Promise);
const API_ROOT = 'http://localhost:8000/';
const responseBody = response => response.body;

export const requests = {
    get: (url) => 
        // jsでの文字列埋め込みはバッククォートを使うこと shift+@
        superagent.get(`${API_ROOT}${url}`).then(responseBody)
        // superagent.get("http://localhost:8000/api/blog_posts")
};
