import { Component } from '@angular/core';
import { LoggerService } from 'src/lib/my-core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'curso';

  constructor(private out: LoggerService){
    out.error("Error");
    out.info("Info");
    out.warn("Warn");
    out.log("Log");
  }
}
