const cacheName = 'news-v1';
const staticAssets = [
    './templates/wallet/addCard.html',
  './templates/wallet/infoCard.html',
  './templates/wallet/wallet.html',
  './static/ewstyle.css',
  './static/mapcss.css',
  './static/mobile.css',
  './static/mainjs',
  './templates/base.html',
  './templates/account.html',
  './templates/credit.html',
  './templates/history.html',
  './templates/home.html',
  './templates/login.html',
  './templates/sign_up.html',
  './templates/welcome.html',
  './__initi__.py',
  './auth.py',
  './database.fb',
  './manifest.json',
  './models.py',
  './sw.js',
  './views.py'

];

self.addEventListener('install', async e => {
  const cache = await caches.open(cacheName);
  await cache.addAll(staticAssets);
  return self.skipWaiting();
});

self.addEventListener('activate', e => {
  self.clients.claim();
});

self.addEventListener('fetch', async e => {
  const req = e.request;
  const url = new URL(req.url);

  if (url.origin === location.origin) {
    e.respondWith(cacheFirst(req));
  } else {
    e.respondWith(networkAndCache(req));
  }
});

async function cacheFirst(req) {
  const cache = await caches.open(cacheName);
  const cached = await cache.match(req);
  return cached || fetch(req);
}

async function networkAndCache(req) {
  const cache = await caches.open(cacheName);
  try {
    const fresh = await fetch(req);
    await cache.put(req, fresh.clone());
    return fresh;
  } catch (e) {
    const cached = await cache.match(req);
    return cached;
  }
}