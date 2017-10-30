package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Controller;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Conf1Template extends SimpleTemplate<List<Controller>> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  protected CharSequence template(final List<Controller> e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import { BrowserModule } from \'@angular/platform-browser\';");
    _builder.newLine();
    _builder.append("import { ErrorHandler, NgModule } from \'@angular/core\';");
    _builder.newLine();
    _builder.append("import { IonicApp, IonicErrorHandler, IonicModule } from \'ionic-angular\';");
    _builder.newLine();
    _builder.append("import { SplashScreen } from \'@ionic-native/splash-screen\';");
    _builder.newLine();
    _builder.append("import { StatusBar } from \'@ionic-native/status-bar\';");
    _builder.newLine();
    _builder.append("import { Camera } from \'@ionic-native/camera\';");
    _builder.newLine();
    _builder.append("import { Geolocation } from \'@ionic-native/geolocation\';");
    _builder.newLine();
    _builder.append("import { HttpModule } from \'@angular/http\';");
    _builder.newLine();
    _builder.append("import { Persistence } from \'../providers/persistence/persistence\';");
    _builder.newLine();
    _builder.append("import { CameraService } from \'../providers/camera-service/camera-service\'; ");
    _builder.newLine();
    _builder.append("import { MapService } from \"../providers/map-service/map-service\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import { MyApp } from \'./app.component\';");
    _builder.newLine();
    _builder.append("import { InicioPage } from \'../pages/inicio/inicio\';");
    _builder.newLine();
    _builder.newLine();
    {
      for(final Controller ctrl : e) {
        {
          boolean _and = false;
          boolean _equals = ctrl.getName().equals("DefaultPageDispatcher");
          boolean _not = (!_equals);
          if (!_not) {
            _and = false;
          } else {
            EObject _eContainer = ctrl.eContainer();
            QualifiedName _fullyQualifiedName = null;
            if (_eContainer!=null) {
              _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
            }
            boolean _endsWith = _fullyQualifiedName.toString().endsWith("controllers");
            _and = _endsWith;
          }
          if (_and) {
            _builder.append("import { ");
            String _firstUpper = StringExtensions.toFirstUpper(ctrl.getName().toLowerCase());
            _builder.append(_firstUpper);
            _builder.append("Page } from \'../pages/");
            String _lowerCase = ctrl.getName().toLowerCase();
            int _length = ctrl.getName().length();
            int _minus = (_length - 1);
            String _substring = _lowerCase.substring(0, _minus);
            _builder.append(_substring);
            _builder.append("/");
            String _lowerCase_1 = ctrl.getName().toLowerCase();
            _builder.append(_lowerCase_1);
            _builder.append("\';");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("@NgModule({ ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("declarations: [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("MyApp,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("InicioPage,");
    _builder.newLine();
    {
      for(final Controller ctrl_1 : e) {
        {
          boolean _and_1 = false;
          boolean _equals_1 = ctrl_1.getName().equals("DefaultPageDispatcher");
          boolean _not_1 = (!_equals_1);
          if (!_not_1) {
            _and_1 = false;
          } else {
            EObject _eContainer_1 = ctrl_1.eContainer();
            QualifiedName _fullyQualifiedName_1 = null;
            if (_eContainer_1!=null) {
              _fullyQualifiedName_1=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_1);
            }
            boolean _endsWith_1 = _fullyQualifiedName_1.toString().endsWith("controllers");
            _and_1 = _endsWith_1;
          }
          if (_and_1) {
            _builder.append("  \t\t");
            String _firstUpper_1 = StringExtensions.toFirstUpper(ctrl_1.getName().toLowerCase());
            _builder.append(_firstUpper_1, "  \t\t");
            _builder.append("Page,");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("imports: [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("BrowserModule,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("HttpModule,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("IonicModule.forRoot(MyApp)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("bootstrap: [IonicApp],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entryComponents: [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("MyApp,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("InicioPage,");
    _builder.newLine();
    {
      for(final Controller ctrl_2 : e) {
        {
          boolean _and_2 = false;
          boolean _equals_2 = ctrl_2.getName().equals("DefaultPageDispatcher");
          boolean _not_2 = (!_equals_2);
          if (!_not_2) {
            _and_2 = false;
          } else {
            EObject _eContainer_2 = ctrl_2.eContainer();
            QualifiedName _fullyQualifiedName_2 = null;
            if (_eContainer_2!=null) {
              _fullyQualifiedName_2=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_2);
            }
            boolean _endsWith_2 = _fullyQualifiedName_2.toString().endsWith("controllers");
            _and_2 = _endsWith_2;
          }
          if (_and_2) {
            _builder.append("  \t\t");
            String _firstUpper_2 = StringExtensions.toFirstUpper(ctrl_2.getName().toLowerCase());
            _builder.append(_firstUpper_2, "  \t\t");
            _builder.append("Page,");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("providers: [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("StatusBar,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("SplashScreen,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{provide: ErrorHandler, useClass: IonicErrorHandler},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Persistence,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("CameraService,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("MapService,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Camera,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Geolocation");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("})");
    _builder.newLine();
    _builder.append("export class AppModule {}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public void preprocess(final List<Controller> e) {
  }
}
