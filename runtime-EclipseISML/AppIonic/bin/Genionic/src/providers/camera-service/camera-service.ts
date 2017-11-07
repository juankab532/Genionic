import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Camera, CameraOptions } from '@ionic-native/camera';

@Injectable()
export class CameraService {

  constructor(public http: Http,public camera: Camera) {
    console.log('Hello CameraServiceProvider Provider');
  }

  takePicture(){ 
    var options: CameraOptions = {
      destinationType: this.camera.DestinationType.DATA_URL,
      targetWidth: 1000,
      targetHeight: 1000,
      quality: 20
    }
    return new Promise((resolve, reject) => {
        this.camera.getPicture( options )
        .then(imageData => {
          resolve(`data:image/jpeg;base64,${imageData}`);
        })
        .catch(error =>{
          reject(error) ;
        });
    });
   
  }

}
