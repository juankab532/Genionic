webpackJsonp([5],{

/***/ 271:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ContactoPageModule", function() { return ContactoPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(38);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__contacto__ = __webpack_require__(282);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var ContactoPageModule = (function () {
    function ContactoPageModule() {
    }
    return ContactoPageModule;
}());
ContactoPageModule = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["a" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__contacto__["a" /* ContactoPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__contacto__["a" /* ContactoPage */]),
        ],
        exports: [
            __WEBPACK_IMPORTED_MODULE_2__contacto__["a" /* ContactoPage */]
        ]
    })
], ContactoPageModule);

//# sourceMappingURL=contacto.module.js.map

/***/ }),

/***/ 282:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ContactoPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(38);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/**
 * Generated class for the ContactoPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
var ContactoPage = (function () {
    function ContactoPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.items = [
            { title: 'item1', id: '1' },
            { title: 'item2', id: '2' },
            { title: 'item3', id: '3' },
            { title: 'item4', id: '4' },
            { title: 'item5', id: '5' },
            { title: 'item6', id: '6' }
        ];
    }
    ContactoPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ContactoPage');
    };
    ContactoPage.prototype.hacerSubmit = function () {
    };
    return ContactoPage;
}());
ContactoPage = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicPage */])(),
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
        selector: 'page-contacto',template:/*ion-inline-start:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/contacto/contacto.html"*/'<!--\n  Generated template for the ContactoPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n\n  <ion-navbar color="primary">\n    <button ion-icon menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Contacto</ion-title>\n  </ion-navbar>\n\n</ion-header>\n\n\n<ion-content padding>\n  <p> Envaianos tu perfil de Deezer para aparecer en a app.</p>\n  <form  (ngSubmit)="hacerSubmit">\n    <ion-list>  \n        <ion-item>\n          <ion-label floating>ID Deezer</ion-label>\n          <ion-input type="text" name="deezerID" clearInput="true" required></ion-input>\n        </ion-item>\n        <ion-item>\n          <ion-label floating>Correo</ion-label>\n          <ion-input type="email" name="email" clearInput="true"></ion-input>\n        </ion-item>\n        <ion-item>\n          <ion-label floating>Comentario</ion-label>\n          <ion-textarea name="comentario" clearInput="true"></ion-textarea>\n        </ion-item>\n\n        <ion-item>\n          <ion-label>No soy un robot</ion-label>\n          <ion-checkbox required></ion-checkbox>\n        </ion-item>\n        <ion-item>\n          <ion-spinner></ion-spinner>\n        </ion-item>\n        <ion-item>\n          <ion-label>Select</ion-label>\n          <ion-select #item >\n            <ion-option *ngFor="let item of items" value="{{item.value}}">\n            {{item.title}} </ion-option>\n          </ion-select>\n        </ion-item>\n\n    </ion-list>\n    <button ion-button type="submit" block full icon-left>\n      <ion-icon name="send"></ion-icon>\n      Enviar\n    </button> \n  </form>\n</ion-content>\n'/*ion-inline-end:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/contacto/contacto.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], ContactoPage);

//# sourceMappingURL=contacto.js.map

/***/ })

});
//# sourceMappingURL=5.main.js.map