webpackJsonp([2],{

/***/ 271:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CancionesPageModule", function() { return CancionesPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__canciones__ = __webpack_require__(280);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var CancionesPageModule = (function () {
    function CancionesPageModule() {
    }
    return CancionesPageModule;
}());
CancionesPageModule = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["a" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__canciones__["a" /* CancionesPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__canciones__["a" /* CancionesPage */]),
        ],
        exports: [
            __WEBPACK_IMPORTED_MODULE_2__canciones__["a" /* CancionesPage */]
        ]
    })
], CancionesPageModule);

//# sourceMappingURL=canciones.module.js.map

/***/ }),

/***/ 279:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DezeerServiceProvider; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(49);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__ = __webpack_require__(104);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var DezeerServiceProvider = (function () {
    function DezeerServiceProvider(http) {
        this.http = http;
        this.deezerAPI = "/deezerAPI"; //Pruebas en el pc 
        //this.deezerAPI="http://api.deezer.com"; //En el movil
        console.log('Hello DezeerServiceProvider Provider');
    }
    DezeerServiceProvider.prototype.getUsers = function () {
        return this.http.get('https://api.myjson.com/bins/mcjrb')
            .map(function (res) { return res.json(); }); //retorna el observable
        /*.subscribe(usuarios=>{
            usuarios.map(userID=>{
                this.getUserDetail(userID);
            });
        });*/
    };
    DezeerServiceProvider.prototype.getUserDetail = function (userID) {
        return this.http.get(this.deezerAPI + '/user/' + userID)
            .map(function (res) { return res.json(); });
        /*.subscribe(data=>{
            console.log(data);
        });*/
    };
    DezeerServiceProvider.prototype.getUserPlaylists = function (userID) {
        return this.http.get(this.deezerAPI + '/user/' + userID + '/playlists')
            .map(function (res) { return res.json(); });
    };
    DezeerServiceProvider.prototype.getPlaylistsSongs = function (playlist) {
        return this.http.get(this.deezerAPI + '/playlist/' + playlist + '/tracks')
            .map(function (res) { return res.json(); });
    };
    return DezeerServiceProvider;
}());
DezeerServiceProvider = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Http */]])
], DezeerServiceProvider);

//# sourceMappingURL=dezeer-service.js.map

/***/ }),

/***/ 280:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CancionesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__providers_dezeer_service_dezeer_service__ = __webpack_require__(279);
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

/***/ })

});
//# sourceMappingURL=2.main.js.map