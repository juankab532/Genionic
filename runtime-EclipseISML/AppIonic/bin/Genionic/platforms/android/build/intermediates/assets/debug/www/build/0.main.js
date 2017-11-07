webpackJsonp([0],{

/***/ 275:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PerfilesPageModule", function() { return PerfilesPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(39);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__perfiles__ = __webpack_require__(284);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var PerfilesPageModule = (function () {
    function PerfilesPageModule() {
    }
    return PerfilesPageModule;
}());
PerfilesPageModule = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["a" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__perfiles__["a" /* PerfilesPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__perfiles__["a" /* PerfilesPage */]),
        ],
        exports: [
            __WEBPACK_IMPORTED_MODULE_2__perfiles__["a" /* PerfilesPage */]
        ]
    })
], PerfilesPageModule);

//# sourceMappingURL=perfiles.module.js.map

/***/ }),

/***/ 278:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CancionesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(39);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__providers_dezeer_service_dezeer_service__ = __webpack_require__(201);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CancionesPage = (function () {
    function CancionesPage(navCtrl, navParams, ds) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.ds = ds;
        this.playlist = this.navParams.get("playlist");
        this.canciones = [];
    }
    CancionesPage.prototype.ionViewDidLoad = function () {
        var _this = this;
        this.ds.getPlaylistsSongs(this.playlist.id).subscribe(function (datos) {
            _this.canciones = datos.data;
        });
        console.log(this.canciones);
    };
    return CancionesPage;
}());
CancionesPage = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicPage */])(),
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
        selector: 'page-canciones',template:/*ion-inline-start:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/canciones/canciones.html"*/'<!--\n  Generated template for the CancionesPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n\n  <ion-navbar color="primary">\n    <button ion-button menuToggle >\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Canciones</ion-title>\n  </ion-navbar>\n\n</ion-header>\n\n\n<ion-content padding>\n  <div class="user">\n    <img src="{{playlist.picture}}">\n    <h1>{{playlist.title}}</h1>\n  </div>\n  <ion-list>\n    <ion-item *ngFor="let c of canciones">\n        <ion-thumbnail item-left>\n            <img src="{{c.album.cover}}" alt="">\n        </ion-thumbnail>\n        <h2>{{c.title}}</h2>\n        <p>{{c.artist.name}} - {{c.album.title}} </p>\n        <audio controls>\n          <source src="{{c.preview}} " type="">\n        </audio>\n    </ion-item>\n  </ion-list>\n\n\n</ion-content>\n'/*ion-inline-end:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/canciones/canciones.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */],
        __WEBPACK_IMPORTED_MODULE_2__providers_dezeer_service_dezeer_service__["a" /* DezeerServiceProvider */]])
], CancionesPage);

//# sourceMappingURL=canciones.js.map

/***/ }),

/***/ 279:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PlayListPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(39);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__canciones_canciones__ = __webpack_require__(278);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__providers_dezeer_service_dezeer_service__ = __webpack_require__(201);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var PlayListPage = (function () {
    function PlayListPage(navCtrl, navParams, ds) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.ds = ds;
        this.user = this.navParams.get("user");
        this.playlists = [];
    }
    PlayListPage.prototype.ionViewDidLoad = function () {
        var _this = this;
        this.ds.getUserPlaylists(this.user.id).subscribe(function (datos) {
            _this.playlists = datos.data;
        });
    };
    PlayListPage.prototype.goToCanciones = function (playlist) {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__canciones_canciones__["a" /* CancionesPage */], { playlist: playlist });
    };
    return PlayListPage;
}());
PlayListPage = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicPage */])(),
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
        selector: 'page-play-list',template:/*ion-inline-start:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/play-list/play-list.html"*/'<!--\n  Generated template for the PlayListPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n\n  <ion-navbar color="primary">\n    <button ion-button menuToggle >\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>PlayList</ion-title>\n  </ion-navbar>\n\n</ion-header>\n\n\n<ion-content padding>\n  <div class="user">\n    <img src="{{user.picture}}" alt="">\n    <h1>{{user.name}}</h1>\n  </div>\n  <ion-list>\n    <ion-item (click)="goToCanciones(p)" *ngFor="let p of playlists">\n      <ion-thumbnail item-left>\n        <img src="{{p.picture}}" alt="">\n      </ion-thumbnail>\n      <h2>{{p.title}}</h2>\n      <p>{{p.nb_tracks}} Canciones</p>\n    </ion-item>\n  </ion-list>\n\n\n</ion-content>\n\n\n'/*ion-inline-end:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/play-list/play-list.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */],
        __WEBPACK_IMPORTED_MODULE_3__providers_dezeer_service_dezeer_service__["a" /* DezeerServiceProvider */]])
], PlayListPage);

//# sourceMappingURL=play-list.js.map

/***/ }),

/***/ 284:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PerfilesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(39);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__play_list_play_list__ = __webpack_require__(279);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__providers_dezeer_service_dezeer_service__ = __webpack_require__(201);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var PerfilesPage = (function () {
    function PerfilesPage(navCtrl, navParams, ds) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.ds = ds;
        this.users = [];
    }
    PerfilesPage.prototype.ionViewDidLoad = function () {
        var _this = this;
        this.ds.getUsers().subscribe(function (usersIDs) {
            usersIDs.map(function (userID) {
                _this.ds.getUserDetail(userID).subscribe(function (user) {
                    _this.users.push(user);
                });
            });
        });
    };
    PerfilesPage.prototype.goToPlayList = function (user) {
        //Lamar una vista y enviar parametro
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__play_list_play_list__["a" /* PlayListPage */], { user: user });
    };
    return PerfilesPage;
}());
PerfilesPage = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicPage */])(),
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
        selector: 'page-perfiles',template:/*ion-inline-start:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/perfiles/perfiles.html"*/'<!--\n  Generated template for the PerfilesPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n\n  <ion-navbar color="primary">\n    <button ion-icon menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Perfiles</ion-title>\n  </ion-navbar>\n\n</ion-header>\n\n\n<ion-content padding>\n  <ion-list>\n    <ion-item (click)="goToPlayList(user)" *ngFor="let user of users">\n        <ion-avatar item-left>\n          <img src="{{user.picture}}">\n        </ion-avatar>\n        <h1>{{user.name}}</h1>\n    </ion-item>\n  </ion-list>\n\n</ion-content>\n'/*ion-inline-end:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/perfiles/perfiles.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */],
        __WEBPACK_IMPORTED_MODULE_3__providers_dezeer_service_dezeer_service__["a" /* DezeerServiceProvider */]])
], PerfilesPage);

//# sourceMappingURL=perfiles.js.map

/***/ })

});
//# sourceMappingURL=0.main.js.map