package mx.com.pelayo.ui.ticket.detail;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.api.entities.TicketInfo;
import mx.com.pelayo.ui.MainActivity;
import mx.com.pelayo.ui.util.DialogFactory;
import mx.com.pelayo.util.Tools;
import mx.com.pelayo.viewmodel.DetailTicketViewModel;

public class TicketDetailFragment extends Fragment {

    private static final String TICKET_ID_PARAM = "ticketId";
    @Inject
    DetailTicketViewModel detailTicketViewModel;
    private ImageView barcode;
    private TextView ticket;
    private TextView creationDate;
    private TextView solutionDate;
    private TextView legend;
    private TextView applicant;
    private TextView expert;
    private TextView category;
    private TextView type;
    private TextView symptom;
    private TextView diagnostic;
    private TextView location;
    private TextView solution;
    private CheckBox remoteSolution;
    private TextView possibleOrigin;
    private TextView waitingForUser;
    private TextView improperMotive;
    private TextView updateDate;
    private TextView closingDate;
    private TextView observations;
    private TextView capturist;
    private CheckBox manualEmail;
    private TextView projectStatus;
    private Integer ticketId;

    private Dialog progressDialog;
    private Dialog errorDialog;

    public TicketDetailFragment() {
        // Required empty public constructor
    }

    public static TicketDetailFragment newInstance(Integer ticketId) {
        TicketDetailFragment fragment = new TicketDetailFragment();
        Bundle args = new Bundle();
        args.putInt(TICKET_ID_PARAM, ticketId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getActivity().getApplicationContext()).getApplicationComponent().inject(this);
        if (getArguments() != null) {
            ticketId = getArguments().getInt(TICKET_ID_PARAM);
        }
    }

    @Override
    public void onResume() {
        MainActivity activity = (MainActivity) getActivity();
        activity.hideBanner();
        activity.setTitle("Detalle de Ticket");
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_detail, container, false);
        barcode = view.findViewById(R.id.barcode);
        barcode.setImageBitmap(Tools.convertToBarcode("" + ticketId));
        ticket = view.findViewById(R.id.ticketId);
        ticket.setText(Tools.addSpacesBetween("" + ticketId, 10));
        creationDate = view.findViewById(R.id.creationDate);
        solutionDate = view.findViewById(R.id.solutionDate);
        legend = view.findViewById(R.id.legend);
        applicant = view.findViewById(R.id.applicant);
        expert = view.findViewById(R.id.expert);
        category = view.findViewById(R.id.category);
        type = view.findViewById(R.id.type);
        symptom = view.findViewById(R.id.symptom);
        diagnostic = view.findViewById(R.id.diagnostic);
        location = view.findViewById(R.id.location);
        solution = view.findViewById(R.id.solution);
        remoteSolution = view.findViewById(R.id.remoteSolution);
        possibleOrigin = view.findViewById(R.id.possibleOrigin);
        waitingForUser = view.findViewById(R.id.waitingForUser);
        improperMotive = view.findViewById(R.id.improperMotive);
        updateDate = view.findViewById(R.id.updateDate);
        closingDate = view.findViewById(R.id.closingDate);
        observations = view.findViewById(R.id.observations);
        capturist = view.findViewById(R.id.capturist);
        manualEmail = view.findViewById(R.id.manualMail);
        projectStatus = view.findViewById(R.id.projectStatus);
        progressDialog = DialogFactory.getProgressDialog(this.getContext(), "Espere...");
        progressDialog.show();
        detailTicketViewModel.getTicketDetail(ticketId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(ticketInfo -> {
                    progressDialog.dismiss();
                    setInfo(ticketInfo);
                }, throwable -> {
                    DialogFactory.DialogListener dialogListener = dialog -> TicketDetailFragment.this.getActivity().onBackPressed();
                    errorDialog = DialogFactory.getErrorDialog(this.getContext(), Tools.parseError(throwable), dialogListener);
                    errorDialog.show();
                });
        return view;
    }

    private void setInfo(TicketInfo ticketInfo) {
        creationDate.setText(ticketInfo.getFechaApertura());
        solutionDate.setText(ticketInfo.getFechaSolucion());
        legend.setText(ticketInfo.getLeyenda());
        applicant.setText(ticketInfo.getSolicitante());
        expert.setText(ticketInfo.getTecnico());
        category.setText(ticketInfo.getCategoria());
        type.setText(ticketInfo.getTipo());
        symptom.setText(ticketInfo.getSintoma());
        diagnostic.setText(ticketInfo.getDiagnostico());
        location.setText(ticketInfo.getLugar());
        solution.setText(ticketInfo.getSolucion());
        remoteSolution.setChecked(ticketInfo.isSolucionRemota());
        possibleOrigin.setText(ticketInfo.getPosibleOrigen());
        waitingForUser.setText(ticketInfo.getEsperandoUsuario());
        improperMotive.setText(ticketInfo.getImprocedenteMotivo());
        updateDate.setText(ticketInfo.getFechaActualizacion());
        closingDate.setText(ticketInfo.getFechaCierre());
        observations.setText(ticketInfo.getObservaciones());
        capturist.setText(ticketInfo.getCapturista());
        manualEmail.setChecked(ticketInfo.isCorreoManual());
        projectStatus.setText(ticketInfo.getStatusProyecto());
    }

}
