package com.example.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}



/*
<?xml version="1.0" encoding="UTF-8"?>
<bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xmlns:camunda="http://camunda.org/schema/1.0/bpmn" id="Definitions_0fr9mxs" targetNamespace="http://bpmn.io/schema/bpmn" exporter="Camunda Modeler" exporterVersion="5.28.0">
  <bpmn:process id="Car-Loan" name="Car Loan" isExecutable="true" camunda:historyTimeToLive="180">
    <bpmn:startEvent id="StartEvent_1">
      <bpmn:outgoing>Flow_1jidcw6</bpmn:outgoing>
    </bpmn:startEvent>
    <bpmn:sequenceFlow id="Flow_1jidcw6" sourceRef="StartEvent_1" targetRef="Activity_10s2iqx" />
    <bpmn:userTask id="Activity_02novwg" name="Apply for Loan">
      <bpmn:incoming>Flow_1aoc714</bpmn:incoming>
      <bpmn:incoming>Flow_1b0fki7</bpmn:incoming>
      <bpmn:outgoing>Flow_1308m5l</bpmn:outgoing>
    </bpmn:userTask>
    <bpmn:sequenceFlow id="Flow_1308m5l" sourceRef="Activity_02novwg" targetRef="Activity_0sjzayh" />
    <bpmn:serviceTask id="Activity_0sjzayh" name="Approval">
      <bpmn:incoming>Flow_1308m5l</bpmn:incoming>
      <bpmn:outgoing>Flow_1i36tzq</bpmn:outgoing>
    </bpmn:serviceTask>
    <bpmn:exclusiveGateway id="Gateway_0y8iiyg" name="Is loan request approved?">
      <bpmn:incoming>Flow_1i36tzq</bpmn:incoming>
      <bpmn:outgoing>Flow_1aoc714</bpmn:outgoing>
    </bpmn:exclusiveGateway>
    <bpmn:sequenceFlow id="Flow_1i36tzq" sourceRef="Activity_0sjzayh" targetRef="Gateway_0y8iiyg" />
    <bpmn:sequenceFlow id="Flow_1aoc714" name="Rejected" sourceRef="Gateway_0y8iiyg" targetRef="Activity_02novwg" />
    <bpmn:userTask id="Activity_1c3ty7b" name="Confirmation of car loan by approver.">
      <bpmn:outgoing>Flow_0sstf3y</bpmn:outgoing>
    </bpmn:userTask>
    <bpmn:sequenceFlow id="Flow_1j0jrix" sourceRef="Activity_10s2iqx" targetRef="Gateway_1s3frfp" />
    <bpmn:userTask id="Activity_10s2iqx" name="Want to buy car?" camunda:formKey="camunda-froms:/forms/WantToBuyNewCar.form">
      <bpmn:incoming>Flow_1jidcw6</bpmn:incoming>
      <bpmn:outgoing>Flow_1j0jrix</bpmn:outgoing>
    </bpmn:userTask>
    <bpmn:exclusiveGateway id="Gateway_1s3frfp" name="Buying, or not?">
      <bpmn:incoming>Flow_1j0jrix</bpmn:incoming>
      <bpmn:outgoing>Flow_1b0fki7</bpmn:outgoing>
      <bpmn:outgoing>Flow_1hswoo7</bpmn:outgoing>
    </bpmn:exclusiveGateway>
    <bpmn:sequenceFlow id="Flow_1b0fki7" name="Yes" sourceRef="Gateway_1s3frfp" targetRef="Activity_02novwg" />
    <bpmn:exclusiveGateway id="Gateway_0g16cy6" name="confirmed by approver">
      <bpmn:incoming>Flow_0sstf3y</bpmn:incoming>
      <bpmn:outgoing>Flow_0b36x95</bpmn:outgoing>
      <bpmn:outgoing>Flow_0xa1ff1</bpmn:outgoing>
    </bpmn:exclusiveGateway>
    <bpmn:sequenceFlow id="Flow_0sstf3y" sourceRef="Activity_1c3ty7b" targetRef="Gateway_0g16cy6" />
    <bpmn:sequenceFlow id="Flow_0b36x95" name="Yes" sourceRef="Gateway_0g16cy6" targetRef="Activity_0l1rkub" />
    <bpmn:eventBasedGateway id="Gateway_11gw5ls" name="Amount payed?">
      <bpmn:incoming>Flow_07h3zj9</bpmn:incoming>
      <bpmn:outgoing>Flow_07cquda</bpmn:outgoing>
      <bpmn:outgoing>Flow_1pyir5c</bpmn:outgoing>
    </bpmn:eventBasedGateway>
    <bpmn:userTask id="Activity_0l1rkub" name="Do you want to pay the loan">
      <bpmn:incoming>Flow_0b36x95</bpmn:incoming>
      <bpmn:incoming>Flow_19v71ic</bpmn:incoming>
      <bpmn:outgoing>Flow_07h3zj9</bpmn:outgoing>
    </bpmn:userTask>
    <bpmn:sequenceFlow id="Flow_07h3zj9" sourceRef="Activity_0l1rkub" targetRef="Gateway_11gw5ls" />
    <bpmn:intermediateCatchEvent id="Event_1161ril" name="Forget to pay">
      <bpmn:incoming>Flow_07cquda</bpmn:incoming>
      <bpmn:outgoing>Flow_1net057</bpmn:outgoing>
      <bpmn:timerEventDefinition id="TimerEventDefinition_11gk4ps" />
    </bpmn:intermediateCatchEvent>
    <bpmn:sequenceFlow id="Flow_07cquda" sourceRef="Gateway_11gw5ls" targetRef="Event_1161ril" />
    <bpmn:intermediateCatchEvent id="Event_1gc14n7" name="amount payed">
      <bpmn:incoming>Flow_1pyir5c</bpmn:incoming>
      <bpmn:outgoing>Flow_1ikvub1</bpmn:outgoing>
      <bpmn:messageEventDefinition id="MessageEventDefinition_1in66yu" />
    </bpmn:intermediateCatchEvent>
    <bpmn:sequenceFlow id="Flow_1pyir5c" sourceRef="Gateway_11gw5ls" targetRef="Event_1gc14n7" />
    <bpmn:sequenceFlow id="Flow_1ikvub1" sourceRef="Event_1gc14n7" targetRef="Activity_132pmf0" />
    <bpmn:serviceTask id="Activity_132pmf0" name="Enjoy!!">
      <bpmn:incoming>Flow_1ikvub1</bpmn:incoming>
      <bpmn:outgoing>Flow_066infj</bpmn:outgoing>
    </bpmn:serviceTask>
    <bpmn:sequenceFlow id="Flow_1net057" sourceRef="Event_1161ril" targetRef="Activity_0hlxbrc" />
    <bpmn:serviceTask id="Activity_0hlxbrc" name="bank restrained the car">
      <bpmn:incoming>Flow_1net057</bpmn:incoming>
      <bpmn:outgoing>Flow_0arc1v4</bpmn:outgoing>
    </bpmn:serviceTask>
    <bpmn:endEvent id="Event_1tvnech">
      <bpmn:incoming>Flow_066infj</bpmn:incoming>
      <bpmn:incoming>Flow_0arc1v4</bpmn:incoming>
      <bpmn:incoming>Flow_10vjvdk</bpmn:incoming>
      <bpmn:incoming>Flow_1hswoo7</bpmn:incoming>
    </bpmn:endEvent>
    <bpmn:sequenceFlow id="Flow_066infj" sourceRef="Activity_132pmf0" targetRef="Event_1tvnech" />
    <bpmn:sequenceFlow id="Flow_0arc1v4" sourceRef="Activity_0hlxbrc" targetRef="Event_1tvnech" />
    <bpmn:sequenceFlow id="Flow_1hswoo7" name="No" sourceRef="Gateway_1s3frfp" targetRef="Event_1tvnech" />
    <bpmn:sequenceFlow id="Flow_0xa1ff1" name="No" sourceRef="Gateway_0g16cy6" targetRef="Activity_0w3pzq3" />
    <bpmn:userTask id="Activity_0w3pzq3" name="Negotiate, with interest rate.">
      <bpmn:incoming>Flow_0xa1ff1</bpmn:incoming>
      <bpmn:outgoing>Flow_17kghud</bpmn:outgoing>
    </bpmn:userTask>
    <bpmn:sequenceFlow id="Flow_17kghud" sourceRef="Activity_0w3pzq3" targetRef="Activity_13bxbqz" />
    <bpmn:serviceTask id="Activity_13bxbqz" name="Bank approved?">
      <bpmn:incoming>Flow_17kghud</bpmn:incoming>
      <bpmn:outgoing>Flow_1e824tp</bpmn:outgoing>
    </bpmn:serviceTask>
    <bpmn:exclusiveGateway id="Gateway_0ts6mtt">
      <bpmn:incoming>Flow_1e824tp</bpmn:incoming>
      <bpmn:outgoing>Flow_19v71ic</bpmn:outgoing>
      <bpmn:outgoing>Flow_10vjvdk</bpmn:outgoing>
    </bpmn:exclusiveGateway>
    <bpmn:sequenceFlow id="Flow_1e824tp" sourceRef="Activity_13bxbqz" targetRef="Gateway_0ts6mtt" />
    <bpmn:sequenceFlow id="Flow_19v71ic" name="Yes" sourceRef="Gateway_0ts6mtt" targetRef="Activity_0l1rkub" />
    <bpmn:sequenceFlow id="Flow_10vjvdk" name="No" sourceRef="Gateway_0ts6mtt" targetRef="Event_1tvnech" />
  </bpmn:process>
  <bpmndi:BPMNDiagram id="BPMNDiagram_1">
    <bpmndi:BPMNPlane id="BPMNPlane_1" bpmnElement="Car-Loan">
      <bpmndi:BPMNShape id="_BPMNShape_StartEvent_2" bpmnElement="StartEvent_1">
        <dc:Bounds x="152" y="349" width="36" height="36" />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_1hkzcag_di" bpmnElement="Activity_10s2iqx">
        <dc:Bounds x="250" y="327" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Gateway_1s3frfp_di" bpmnElement="Gateway_1s3frfp" isMarkerVisible="true">
        <dc:Bounds x="385" y="342" width="50" height="50" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="373" y="318" width="74" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0qxldc7_di" bpmnElement="Activity_0hlxbrc">
        <dc:Bounds x="1570" y="450" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Event_1tvnech_di" bpmnElement="Event_1tvnech">
        <dc:Bounds x="1782" y="412" width="36" height="36" />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0kyfm3b_di" bpmnElement="Activity_132pmf0">
        <dc:Bounds x="1570" y="327" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_06x4pf7_di" bpmnElement="Activity_02novwg">
        <dc:Bounds x="486" y="327" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0vd8w0u_di" bpmnElement="Activity_0sjzayh">
        <dc:Bounds x="642" y="327" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Gateway_0y8iiyg_di" bpmnElement="Gateway_0y8iiyg" isMarkerVisible="true">
        <dc:Bounds x="798" y="342" width="50" height="50" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="786" y="312" width="74" height="27" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0ire4cg_di" bpmnElement="Activity_1c3ty7b">
        <dc:Bounds x="904" y="327" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0wcdvz1_di" bpmnElement="Activity_0w3pzq3">
        <dc:Bounds x="1060" y="80" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Gateway_0g16cy6_di" bpmnElement="Gateway_0g16cy6" isMarkerVisible="true">
        <dc:Bounds x="1085" y="342" width="50" height="50" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1078" y="402" width="64" height="27" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0g15npd_di" bpmnElement="Activity_0l1rkub">
        <dc:Bounds x="1216" y="327" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_1drs49s_di" bpmnElement="Activity_13bxbqz">
        <dc:Bounds x="1216" y="80" width="100" height="80" />
        <bpmndi:BPMNLabel />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Gateway_0ts6mtt_di" bpmnElement="Gateway_0ts6mtt" isMarkerVisible="true">
        <dc:Bounds x="1241" y="215" width="50" height="50" />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Gateway_11gw5ls_di" bpmnElement="Gateway_11gw5ls">
        <dc:Bounds x="1372" y="342" width="50" height="50" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1358" y="318" width="77" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Event_1161ril_di" bpmnElement="Event_1161ril">
        <dc:Bounds x="1478" y="472" width="36" height="36" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1463" y="515" width="66" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Event_1gc14n7_di" bpmnElement="Event_1gc14n7">
        <dc:Bounds x="1478" y="349" width="36" height="36" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1461" y="392" width="70" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNEdge id="Flow_1aoc714_di" bpmnElement="Flow_1aoc714">
        <di:waypoint x="823" y="392" />
        <di:waypoint x="823" y="520" />
        <di:waypoint x="536" y="520" />
        <di:waypoint x="536" y="407" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="658" y="502" width="44" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1b0fki7_di" bpmnElement="Flow_1b0fki7">
        <di:waypoint x="435" y="367" />
        <di:waypoint x="486" y="367" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="452" y="349" width="18" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1308m5l_di" bpmnElement="Flow_1308m5l">
        <di:waypoint x="586" y="367" />
        <di:waypoint x="642" y="367" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1i36tzq_di" bpmnElement="Flow_1i36tzq">
        <di:waypoint x="742" y="367" />
        <di:waypoint x="798" y="367" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="769" y="99" width="47" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1jidcw6_di" bpmnElement="Flow_1jidcw6">
        <di:waypoint x="188" y="367" />
        <di:waypoint x="250" y="367" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1j0jrix_di" bpmnElement="Flow_1j0jrix">
        <di:waypoint x="350" y="367" />
        <di:waypoint x="385" y="367" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1hswoo7_di" bpmnElement="Flow_1hswoo7">
        <di:waypoint x="410" y="392" />
        <di:waypoint x="410" y="600" />
        <di:waypoint x="1800" y="600" />
        <di:waypoint x="1800" y="448" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1098" y="582" width="15" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_0sstf3y_di" bpmnElement="Flow_0sstf3y">
        <di:waypoint x="1004" y="367" />
        <di:waypoint x="1085" y="367" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_0b36x95_di" bpmnElement="Flow_0b36x95">
        <di:waypoint x="1135" y="367" />
        <di:waypoint x="1216" y="367" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1167" y="349" width="18" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_0xa1ff1_di" bpmnElement="Flow_0xa1ff1">
        <di:waypoint x="1110" y="342" />
        <di:waypoint x="1110" y="160" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1118" y="251" width="15" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_07h3zj9_di" bpmnElement="Flow_07h3zj9">
        <di:waypoint x="1316" y="367" />
        <di:waypoint x="1372" y="367" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_07cquda_di" bpmnElement="Flow_07cquda">
        <di:waypoint x="1397" y="392" />
        <di:waypoint x="1397" y="490" />
        <di:waypoint x="1478" y="490" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1pyir5c_di" bpmnElement="Flow_1pyir5c">
        <di:waypoint x="1422" y="367" />
        <di:waypoint x="1478" y="367" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1ikvub1_di" bpmnElement="Flow_1ikvub1">
        <di:waypoint x="1514" y="367" />
        <di:waypoint x="1570" y="367" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1net057_di" bpmnElement="Flow_1net057">
        <di:waypoint x="1514" y="490" />
        <di:waypoint x="1570" y="490" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_0arc1v4_di" bpmnElement="Flow_0arc1v4">
        <di:waypoint x="1670" y="490" />
        <di:waypoint x="1730" y="490" />
        <di:waypoint x="1730" y="430" />
        <di:waypoint x="1782" y="430" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_066infj_di" bpmnElement="Flow_066infj">
        <di:waypoint x="1670" y="367" />
        <di:waypoint x="1726" y="367" />
        <di:waypoint x="1726" y="430" />
        <di:waypoint x="1782" y="430" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_10vjvdk_di" bpmnElement="Flow_10vjvdk">
        <di:waypoint x="1291" y="240" />
        <di:waypoint x="1800" y="240" />
        <di:waypoint x="1800" y="412" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1538" y="222" width="15" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_17kghud_di" bpmnElement="Flow_17kghud">
        <di:waypoint x="1160" y="120" />
        <di:waypoint x="1216" y="120" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1e824tp_di" bpmnElement="Flow_1e824tp">
        <di:waypoint x="1266" y="160" />
        <di:waypoint x="1266" y="215" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_19v71ic_di" bpmnElement="Flow_19v71ic">
        <di:waypoint x="1266" y="265" />
        <di:waypoint x="1266" y="327" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="1272" y="294" width="18" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
    </bpmndi:BPMNPlane>
  </bpmndi:BPMNDiagram>
</bpmn:definitions>

 */