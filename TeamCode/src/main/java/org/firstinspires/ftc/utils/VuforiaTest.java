package org.firstinspires.ftc.utils;

/**
 * Created by Evyn on 10/3/2017.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

public class VuforiaTest extends LinearOpMode{
    VuforiaLocalizer vuforia;
    private boolean sense = false;
    VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
    VuforiaTrackable relicTemplate = relicTrackables.get(0);
    public static final String TAG = "Vuforia VuMark Sample";
    RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
    RelicRecoveryVuMark L = RelicRecoveryVuMark.LEFT;
    RelicRecoveryVuMark R = RelicRecoveryVuMark.RIGHT;
    RelicRecoveryVuMark C = RelicRecoveryVuMark.CENTER;
    OpenGLMatrix lastLocation = null;

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    public void runOpMode(){
        /*
         * To start up Vuforia, tell it the view that we wish to use for camera monitor (on the RC phone);
         * If no camera monitor is desired, use the parameterless constructor instead (commented out below).
         */
        int cameraMonitorViewId = hardwareMap.appContext.getResources()
                    .getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AZaVXY3/////AAAAGV8AvdXe40mSkhlx5ieOk+5fLIkMWaowsR8BStQ2Ez6Kb7" +
                    "LgrxlKRjyHvW5h/Gctp9g0i9XxN6mE4sE8TxG9BXheD7LEPxVro1mrafX8rMtbnggt4g3eqA/TVyXCNFeln70z" +
                    "+8XsNaSl8K1bLpf7zvhGtJaP5wnMeoXRnWQgM4FNMtpnu88dJ5oYYz7oHzKiHwS/LPtKqETPyNbJMUuBfEVwR+W" +
                    "CnBJV1f9iwy5xXZ1KIRh7zY34yhsycbDYodagPRCcUFQc+reDbN+qYXEhlagQRD3bY+NA8Bs607UebkWL4Rc8idt" +
                    "TELK3J6ND41g5j62qhLFBr6DaLmdtaobkdaRCgMZpe6rW3OsqpCTELDLZ";

        /*
         * We also indicate which camera on the RC that we wish to use.
         * Here we chose the back (HiRes) camera (for greater range), but
         * for a competition robot, the front camera might be more convenient.
         */
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        telemetry.addData(">", "Press Play to start");
        telemetry.update();
        waitForStart();

        relicTrackables.activate();

        while (opModeIsActive()) {

            //UNKNOWN, LEFT, CENTER, RIGHT
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                /* Found an instance of the template. In the actual game, you will probably
                 * loop until this condition occurs, then move on to act accordingly depending
                 * on which VuMark was visible. */
                telemetry.addData("VuMark", "%s visible", vuMark);

                /* For fun, we also exhibit the navigational pose. In the Relic Recovery game,
                 * it is perhaps unlikely that you will actually need to act on this pose information, but
                 * we illustrate it nevertheless, for completeness. */
                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener)relicTemplate.getListener()).getPose();
                telemetry.addData("Pose", format(pose));

                /* We further illustrate how to decompose the pose into useful rotational and
                 * translational components */
                if (pose != null) {
                    VectorF trans = pose.getTranslation();
                    Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

                        // Extract the X, Y, and Z components of the offset of the target relative to the robot
                    double tX = trans.get(0);
                    double tY = trans.get(1);
                    double tZ = trans.get(2);

                        // Extract the rotational components of the target relative to the robot
                    double rX = rot.firstAngle;
                    double rY = rot.secondAngle;
                    double rZ = rot.thirdAngle;
                    }
                }
                else {
                    telemetry.addData("VuMark", "not visible");
                }

                telemetry.update();
            }
        }

        String format(OpenGLMatrix transformationMatrix) {
            return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
        }

}